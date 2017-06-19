# RxJava2Examples
RxJava2 Examples——它可能是从RxJava1跳到RxJava2（学习RxJava2）最好的例子Demo

> RxJava 1.x 到RxJava 2.x的无缝对接  
无需学习RxJava 1.x,直接学习RxJava 2.x  
完备齐全的操作符示例  
支持与Retrofit交互处理示例  
Activity基类封装处理 

## RxJava 1.x 到 RxJava 2.x 变化一览

RxJava 1.x -> RxJava 2.x

* `onCompleted` -> `onComplete` - without the trailing d
* `Func1` -> `Function`
* `Func2` -> `BiFunction`
* `CompositeSubscription` -> `CompositeDisposable`
* `limit` operator has been removed - Use `take` in RxJava2
* and much more.

## 一些操作符的解释

* `Map` -> transform the items emitted by an Observable by applying a function to each item
* `Zip` -> combine the emissions of multiple Observables together via a specified function and emit single items for each combination based on the results of this function
* `Filter` -> emit only those items from an Observable that pass a predicate test
* `FlatMap` -> transform the items emitted by an Observable into Observables, then flatten the emissions from those into a single Observable
* `Take` -> emit only the first n items emitted by an Observable
* `Reduce` -> apply a function to each item emitted by an Observable, sequentially, and emit the final value
* `Skip` -> suppress the first n items emitted by an Observable
* `Buffer` -> periodically gather items emitted by an Observable into bundles and emit these bundles rather than emitting the items one at a time
* `Concat` -> emit the emissions from two or more Observables without interleaving them
* `Replay` -> ensure that all observers see the same sequence of emitted items, even if they subscribe after the Observable has begun emitting items
* `Merge` -> combine multiple Observables into one by merging their emissions

## 尽情地下载运行，开始感受RxJava 2.x 的强大魅力吧~

### Contributing to RxJava 2 Android Samples
Just make pull request. You are in!

该例子借鉴了以下项目：
 * [https://github.com/amitshekhariitbhu/RxJava2-Android-Samples](https://github.com/amitshekhariitbhu/RxJava2-Android-Samples) 

## 关于作者
    南尘<br>
    四川成都<br>
    [其它开源](https://github.com/nanchen2251/)<br>
    [博客园](http://www.cnblogs.com/liushilin/)