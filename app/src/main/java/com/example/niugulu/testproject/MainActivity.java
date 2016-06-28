package com.example.niugulu.testproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func2;

public class MainActivity extends AppCompatActivity {

    private List<Integer> data = new ArrayList<>();

    @BindView(R.id.tv_create_observable)
    TextView createObservableView;

    @BindView(R.id.tv_filter_method)
    TextView filterMethodView;

    @BindView(R.id.tv_take_method)
    TextView takeMethodView;

    @BindView(R.id.tv_take_last_method)
    TextView takeLastMethodView;

    @BindView(R.id.tv_distinct_method)
    TextView distinctMethodView;

    @BindView(R.id.tv_first_method)
    TextView firstMethodView;

    @BindView(R.id.tv_skip_method)
    TextView skipMethodView;

    @BindView(R.id.tv_element_at_method)
    TextView elementAtMethodView;

    @BindView(R.id.tv_sampling_method)
    TextView samplingMethodView;

    @BindView(R.id.tv_timeout_method)
    TextView timeoutMethodView;

    @BindView(R.id.tv_debounce_method)
    TextView debounceMethodView;

    @BindView(R.id.tv_map_method)
    TextView mapMethodView;

    @BindView(R.id.tv_flat_map_method)
    TextView flatMapMethodView;

    @BindView(R.id.tv_flat_map_interable_method)
    TextView flatMapIterableMethodView;

    @BindView(R.id.tv_scan_method)
    TextView scanMethodView;

    @BindView(R.id.tv_group_by_method)
    TextView groupByMethodView;

    @BindView(R.id.tv_buffer_method)
    TextView bufferMethodView;

    @BindView(R.id.tv_window_method)
    TextView windowMethodView;

    @BindView(R.id.tv_cast_method)
    TextView castMethodView;

    @BindView(R.id.tv_merge_method)
    TextView mergeMethodView;

    @BindView(R.id.tv_zip_method)
    TextView zipMethodView;

    @BindView(R.id.tv_join_method)
    TextView joinMethodView;

    @BindView(R.id.tv_combine_latest_method)
    TextView combineLatestMethodView;

    @BindView(R.id.tv_switch_method)
    TextView switchMethodView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        for (int i = 0; i < 10; i++) {
            data.add(i);
        }

        initView();
    }

    private void initView() {
        RxView.clicks(createObservableView)
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        startActivity(new Intent(MainActivity.this, CreateObservableActivity.class));
                    }
                });

        RxView.clicks(filterMethodView)
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        useFilterMethod();
                    }
                });

        RxView.clicks(takeMethodView)
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(this::useTakeMethod);

        RxView.clicks(takeLastMethodView)
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(this::useTakeLastMethod);

        RxView.clicks(distinctMethodView)
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(this::useDistinctMethod);

        RxView.clicks(firstMethodView)
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(this::useFirstMethod);

        RxView.clicks(skipMethodView)
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(this::useSkipMethod);

        RxView.clicks(elementAtMethodView)
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(this::useElementAtMethod);

        RxView.clicks(samplingMethodView)
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(this::useSamplingMethod);

        RxView.clicks(timeoutMethodView)
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(this::useTimeoutMethod);

        RxView.clicks(debounceMethodView)
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(this::useDebounceMethod);

        RxView.clicks(mapMethodView)
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(this::useMapMethod);

        RxView.clicks(flatMapMethodView)
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(this::useFlatMapMethod);

        RxView.clicks(flatMapIterableMethodView)
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(this::useFlatMapIterable);

        RxView.clicks(scanMethodView)
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(this::useScanMethod);

        RxView.clicks(groupByMethodView)
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(this::useGroupByMethod);

        RxView.clicks(bufferMethodView)
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(this::useBufferMethod);

        RxView.clicks(windowMethodView)
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(this::useWindowMethod);

        RxView.clicks(castMethodView)
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(this::useCastMethod);

        RxView.clicks(mergeMethodView)
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(this::useMergeMethod);

        RxView.clicks(zipMethodView)
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(this::useZipMethod);

        RxView.clicks(combineLatestMethodView)
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(this::useCombineLatestMethod);

        RxView.clicks(switchMethodView)
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(this::useSwitchMethod);
    }

    private void useSwitchMethod(Void v) {
        Observable observable = Observable.interval(1000, TimeUnit.MILLISECONDS)
                .map(i -> Observable.interval(500, TimeUnit.MILLISECONDS).take(5))
                .take(2);

        Observable.switchOnNext(observable)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(i -> {
                    switchMethodView.setText(i + "");
                    Log.d("useSwitchMethod", "i:" + i);
                });
    }

    private void useCombineLatestMethod(Void v) {
        //作用于最近发送的数据项 如果Observable1发射了A并且Observable2发射了B和C，combineLatest()将会分组处理AB和AC

        Observable observable1 = Observable.interval(2, TimeUnit.SECONDS).take(10);
        Observable observable2 = Observable.interval(1, TimeUnit.SECONDS).take(20);
        Observable.combineLatest(observable1, observable2, new Func2<Long, Long, String>() {

            @Override
            public String call(Long aLong, Long aLong2) {
                return aLong + "" + aLong2;
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(str -> combineLatestMethodView.setText((String) str));
    }

    private void useZipMethod(Void v) {
        //将observables进行处理然后发射出去
        Observable.from(data)
                .zipWith(Observable.interval(500, TimeUnit.MILLISECONDS), (i, j) -> i + "" + j)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(j -> zipMethodView.setText(j));
    }

    private void useMergeMethod(Void v) {
        //合并多个observable
        Observable.from(data)
                .mergeWith(Observable.just(1, 2, 3))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(i -> {
                    mergeMethodView.setText(i + "");
                    Log.d("mergeMethodView", "i:" + i);
                });
    }

    private void useCastMethod(Void v) {
        //转换每个数据的类型
        Observable.from(data)
                .cast(Long.class)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("cast", e.getMessage());
                    }

                    @Override
                    public void onNext(Long aLong) {

                    }
                });
    }

    private void useWindowMethod(Void v) {
        //将数据X个 为一组observable 然后发射
        Observable.from(data)
                .window(3)
                .subscribe(i -> i.observeOn(AndroidSchedulers.mainThread())
                        .subscribe(j -> windowMethodView.setText(j + "")));
    }

    private void useBufferMethod(Void v) {
        //将数据X个为一组列表 然后一组打包发射
        Observable.from(data)
                .buffer(3)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integers -> bufferMethodView.setText(integers.size() + ""));
    }

    private void useGroupByMethod(Void v) {
        //将observable按照一定的规则进行划分 多个observable 并且都有key
        Observable.from(data)
                .groupBy(integer -> integer > 5)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(i -> {
                    i.subscribe(integer -> Log.d("useGroupByMethod", integer + "key:" + i.getKey()));
                });
    }

    private void useScanMethod(Void v) {
        //当次发射的数据经过scan处理，然后发射出去，并同时等下下一次的scan处理
        Observable.from(data)
                .scan((i, j) -> i + j)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(i -> scanMethodView.setText(i + ""));
    }

    private void useFlatMapIterable(Void v) {
        List<String> tempData = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            tempData.add("flatMap" + i);
        }
        Observable.from(data)
                .flatMapIterable(integer -> tempData)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(str -> flatMapMethodView.setText(str));
    }

    private void useFlatMapMethod(Void v) {
        //它发射一个数据序列，这些数据本身也可以发射Observable
        //然后就把所有想要发射的数据平铺但是顺序会乱
        //ConcatMap顺序不会乱
        //SwitchMap取消之前订阅的observable重新订阅新的observable
        List<String> tempData = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            tempData.add("flatMap" + i);
        }
        Observable.from(data)
                .flatMap(observable -> Observable.from(tempData))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(i -> {
                    flatMapMethodView.setText(i + "");
                    Log.d("useFlatMapMethod", i + "");
                });

    }

    private void useMapMethod(Void v) {
        Observable.from(data)
                .map(i -> "map" + i)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(str -> mapMethodView.setText(str));
    }

    private void useDebounceMethod(Void v) {
        //指定一定时间段 如果时间段内没有发射数据 就发射最后一次的数据
        Observable.from(data)
                .debounce(500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> debounceMethodView.setText(integer + ""));
    }

    private void useTimeoutMethod(Void v) {
        //定制一个时间段，期望时间段内至少又一次发射数据不然就走error
        Observable.from(data)
                .timeout(100, TimeUnit.MICROSECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        Log.d("useTimeoutMethod", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("useTimeoutMethod", e.getMessage());
                    }

                    @Override
                    public void onNext(Integer integer) {
                        timeoutMethodView.setText(integer + "");
                    }
                });
    }

    private void useSamplingMethod(Void v) {
        //指定时间段 取离发射时间段内最近的一次数据
        Observable.from(data)
                .sample(300, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Integer -> samplingMethodView.setText(Integer + ""));
    }

    private void useElementAtMethod(Void v) {
        //指定发射某个数据
        Observable.from(data)
                .elementAt(5)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Integer -> elementAtMethodView.setText(Integer + ""));
    }

    private void useSkipMethod(Void v) {
        //跳过前n条数据 skipLast 同理跳过最后几个
        Observable.from(data)
                .skip(3)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Integer -> skipMethodView.setText(Integer + ""));
    }

    private void useFirstMethod(Void v) {
        //发射第一个数据，last同理发送最后一个
        Observable.from(data)
                .first()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Integer -> firstMethodView.setText(Integer + ""));
    }

    private void useDistinctMethod(Void v) {
        //有且只有一次 去掉重复的发射数据
        Observable.from(data)
                .take(2)
                .repeat(3)
                .distinct()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Integer -> distinctMethodView.setText(Integer + ""));
    }

    private void useTakeLastMethod(Void v) {
        //取后X项
        Observable.from(data)
                .takeLast(1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Integer -> takeLastMethodView.setText(Integer + ""));
    }

    private void useTakeMethod(Void v) {
        //取前项
        Observable.from(data)
                .take(3)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        Log.d("takeMethod", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        takeMethodView.setText(integer + "");
                    }
                });

    }

    private void useFilterMethod() {
        //过滤
        Observable.from(data)
                .filter(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) {
                        return integer > 5;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        Log.d("filterMethod", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        filterMethodView.setText(integer + "");
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
