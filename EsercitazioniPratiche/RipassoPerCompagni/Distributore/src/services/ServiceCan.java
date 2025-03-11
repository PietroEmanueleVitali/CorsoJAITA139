package services;

import dao.DaoCan;
import dao.IDao;
import java.util.Map;
import model.Can;

public class ServiceCan {

    private IDao<Can> daoCan;
    private static ServiceCan serviceCan;

    private ServiceCan()
    {
        daoCan = DaoCan.getInstance();
    }

    public static synchronized ServiceCan getInstance()
    {
        if(serviceCan == null)
        {
            serviceCan = new ServiceCan();
            return serviceCan;
        }
        return serviceCan;
    }

    public void printAll()
    {
        Map<Integer, Can> map = daoCan.readAll();
        for(var can : map.values())
        {
            System.out.println(can.toString());
        }
    }

}
