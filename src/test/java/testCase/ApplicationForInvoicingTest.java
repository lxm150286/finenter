package testCase;

import org.testng.annotations.Test;

import static contract.ApplicationForInvoicing.*;

/**
 * @Classname ApplicationForInvoicingTest
 * @Description TODO
 * @Date 2019/7/2 16:54
 * @Created by:lixiaoming1
 */
public class ApplicationForInvoicingTest {
    @Test(description = "批量造单，创建开票主表，根据主表的开票申请单号关联创建子表", invocationCount =1000,threadPoolSize =20,priority = 0)
    public void test1() throws Exception{
        invoiceSalesApplicationBatch();
        System.out.printf("Thrad Id : %s%n",Thread.currentThread().getId());
    }
    @Test(description = "根据开票申请主表已存在的申请编号，创建子表订单", priority = 1)
    public void test2() throws Exception{
        subInvoiceSalesApplication("kp33529");
    }
    @Test(description = "传入申请编号在开票主表创建一条记录，同时创建子表订单", priority = 2)
    public void test3() throws Exception{
        invoiceSalesApplication("kp3234798");
    }
    @Test(description = "传入申请编号在开票主表创建一条记录，同时创建子表订单，EC订单编号为指定的单号", priority =3)
    public void test4() throws Exception{
        invoiceSalesApplication("kp37698",false);
    }
}
