package com.functional.pgming.java.warmup.funcexrcisebdd;

import java.util.List;

public interface EtlEngine {

    void extract(String srcSystem,List<List<String>> rawData);
    void transform(String tgtSystem);
    void load(String tgtSystem);

}
