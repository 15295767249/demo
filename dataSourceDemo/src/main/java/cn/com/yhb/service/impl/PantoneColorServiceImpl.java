package cn.com.yhb.service.impl;

import cn.com.yhb.ds1.mapper.PantoneColorMapper;
import cn.com.yhb.model.PantoneColor;
import cn.com.yhb.service.PantoneColorService;
import cn.com.yhb.utils.HtmlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PantoneColorServiceImpl implements PantoneColorService {

    @Autowired
    private PantoneColorMapper pantoneColorMapper;

    @Override
    public boolean add(String file) {
        List<PantoneColor> pantoneColors = HtmlParser.getPontoneColor(file);
        for (PantoneColor pantoneColor : pantoneColors) {
            pantoneColorMapper.add(pantoneColor);
        }
        return true;
    }

    @Override
    public List<Map<String, List<PantoneColor>>> findPantoneColors() {
        List<Map<String, List<PantoneColor>>> result = new ArrayList<Map<String, List<PantoneColor>>>();
        List<String> types = pantoneColorMapper.findTypes();
        for (String type: types) {
            Map<String, List<PantoneColor>> map = new HashMap<String, List<PantoneColor>>();
            List<PantoneColor> pantoneColors = pantoneColorMapper.findPantoneColors(type);
            map.put(type, pantoneColors);
            result.add(map);
        }
        return result;
    }
}
