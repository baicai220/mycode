package com.powernode.proxy.service;

/**
 * @author 动力节点
 * @version 1.0
 * @className OrderServiceImplSub
 * @since 1.0
 **/
public class OrderServiceImplSub extends OrderServiceImpl{

    @Override
    public void generate() {
        long begin = System.currentTimeMillis();
        super.generate();
        long end = System.currentTimeMillis();
        System.out.println("耗时"+(end - begin)+"毫秒");
    }

    @Override
    public void modify() {
        long begin = System.currentTimeMillis();
        super.modify();
        long end = System.currentTimeMillis();
        System.out.println("耗时"+(end - begin)+"毫秒");
    }

    @Override
    public void detail() {
        long begin = System.currentTimeMillis();
        super.detail();
        long end = System.currentTimeMillis();
        System.out.println("耗时"+(end - begin)+"毫秒");
    }
}
