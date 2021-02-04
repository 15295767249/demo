package cn.com.yhb.service;

import cn.com.yhb.model.PantoneColor;

import java.util.List;
import java.util.Map;

public interface PantoneColorService {

    boolean add(String file);

    List<Map<String, List<PantoneColor>>> findPantoneColors();
}
