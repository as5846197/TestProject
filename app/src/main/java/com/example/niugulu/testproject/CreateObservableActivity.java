package com.example.niugulu.testproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func0;

/**
 * Created by zhangcaoyang on 16/6/22.
 */
public class CreateObservableActivity extends AppCompatActivity {

    private List<Integer> data = new ArrayList<>();

    @BindView(R.id.create_method)
    TextView createMethodView;

    @BindView(R.id.from_method)
    TextView fromMethodView;

    @BindView(R.id.just_method)
    TextView justMethodView;

    @BindView(R.id.repeat_method)
    TextView repeatMethodView;

    @BindView(R.id.range_method)
    TextView rangeMethodView;

    @BindView(R.id.interval_method)
    TextView intervalMethodView;

    @BindView(R.id.timer_method_1)
    TextView timerMethodView1;

    @BindView(R.id.timer_method_2)
    TextView timerMethodView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_create_observable_layout);
        ButterKnife.bind(this);
        for (int i = 0; i < 4; i++) {
            data.add(i);
        }
        initView();
    }

    private void initView() {
        RxView.clicks(createMethodView)
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        useCreateMethodInitObservable();
                    }
                });

        RxView.clicks(fromMethodView)
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        useFromMethodInitObservable();
                    }
                });

        RxView.clicks(justMethodView)
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        useJustMethodInitObservable();
                    }
                });

        RxView.clicks(repeatMethodView)
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        useRepeatMethodInitObservable();
                    }
                });

        RxView.clicks(rangeMethodView)
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        useRangeMethodInitObservable();
                    }
                });

        RxView.clicks(intervalMethodView)
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        useIntervalMethodInitObservable();
                    }
                });

        RxView.clicks(timerMethodView1)
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        useTimerMethodInitObservable1();
                    }
                });

        RxView.clicks(timerMethodView2)
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        useTimerMethodInitObservable2();
                    }
                });

    }

    private void useTimerMethodInitObservable2() {
        //X时间后发射0然后每隔Y时间增加一个数字
        Observable.timer(5, 1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {
                        Log.d("timerMethod", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        timerMethodView2.setText(aLong + "");
                    }
                });
    }

    private void useTimerMethodInitObservable1() {
        //x时间后发射数字0
        Observable.timer(1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {
                        Log.d("timerMethod", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        timerMethodView1.setText(aLong + "");
                    }
                });
    }

    private void useIntervalMethodInitObservable() {
        //从0开始每隔x时间发射一个数字
        Observable.interval(1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {
                        Log.d("intervalMethod", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        intervalMethodView.setText(aLong + "");
                    }
                });
    }

    private void useRangeMethodInitObservable() {
        //从一个指定的数字开始发射n个数字
        Observable.range(10, 3)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        Log.d("rangeMethod", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        rangeMethodView.setText(integer + "");
                    }
                });
    }

    private void useRepeatMethodInitObservable() {
        //重复发送数据
        Observable.from(data)
                .repeat(3)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {

                    @Override
                    public void onCompleted() {
                        Log.d("repeatMethod", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        repeatMethodView.setText(integer + "");
                    }
                });
    }

    private void useJustMethodInitObservable() {
        Observable.just(1, 2, 3, 4)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        Log.d("justMethod", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        justMethodView.setText(integer + "");
                    }
                });
    }

    private void useFromMethodInitObservable() {
        Observable.from(data)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {

                    @Override
                    public void onCompleted() {
                        Log.d("fromMethod", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        fromMethodView.setText(integer + "");
                    }
                });
    }

    private void useCreateMethodInitObservable() {
        Observable observable = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                subscriber.onNext(1);
                subscriber.onNext(2);
                subscriber.onNext(3);
                subscriber.onNext(4);
                subscriber.onCompleted();
            }
        });
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onCompleted() {
                        Log.d("createMethod", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer o) {
                        createMethodView.setText(o + "");
                    }
                });
    }


}
