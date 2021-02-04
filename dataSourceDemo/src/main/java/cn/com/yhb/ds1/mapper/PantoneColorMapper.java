package cn.com.yhb.ds1.mapper;

import cn.com.yhb.model.PantoneColor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PantoneColorMapper {

    int add(PantoneColor pantoneColor);

    List<String> findTypes();

    List<PantoneColor> findPantoneColors(String type);

}
