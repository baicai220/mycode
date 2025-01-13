package com.powernode.spring6.bean;

import java.util.Arrays;

/**
 * @author 动力节点
 * @version 1.0
 * @className QianDaYe
 * @since 1.0
 **/
public class QianDaYe {
    private String[] aiHaos;

    // 多个女性朋友
    private Woman[] womens;

    public void setWomens(Woman[] womens) {
        this.womens = womens;
    }

    public void setAiHaos(String[] aiHaos) {
        this.aiHaos = aiHaos;
    }

    @Override
    public String toString() {
        return "QianDaYe{" +
                "aiHaos=" + Arrays.toString(aiHaos) +
                ", womens=" + Arrays.toString(womens) +
                '}';
    }
}
