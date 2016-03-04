package ahpu.ssh.city.service;

import java.util.List;
import java.util.Set;

import ahpu.ssh.city.model.City;
import ahpu.ssh.city.model.Province;

public interface ProvinceService {
    // 获得所有省份
    List<Province> getAllProvinces(); 
    
    // 获得所选省份下的城市
    Set<City> getCitiesOfProvince(int provinceId);
}