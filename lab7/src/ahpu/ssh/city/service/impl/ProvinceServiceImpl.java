package ahpu.ssh.city.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import ahpu.ssh.city.dao.ProvinceDao;
import ahpu.ssh.city.dao.impl.ProvinceDaoImpl;
import ahpu.ssh.city.model.City;
import ahpu.ssh.city.model.Province;
import ahpu.ssh.city.service.ProvinceService;
import ahpu.ssh.city.util.HibernateSessionFactory;

public class ProvinceServiceImpl implements ProvinceService {
    // 在Service层创建DAO对象
    private ProvinceDao provinceDao = new ProvinceDaoImpl();

    public List<Province> getAllProvinces() {
        Session s = HibernateSessionFactory.getSession();
        provinceDao.setSession(s);// 向DAO层“注入”Session对象
        List<Province> allProvinces = provinceDao.findAll();
        Province p = new Province(); // 人为增加一个用于提示的“假省份”
        p.setId(-1);
        p.setName("----请选择省份----");
        allProvinces.add(0, p); // 加到List的首个位置
        return allProvinces;
    }

    public Set<City> getCitiesOfProvince(int provinceId) {
        Session s = HibernateSessionFactory.getSession();
        provinceDao.setSession(s);
        Province p = provinceDao.find(provinceId);
        if (p == null) { // 首次进入页面时，provinceId为-1
            return new HashSet<City>();
        }
        return p.getCities();
    }
}