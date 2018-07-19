package beans;

import java.util.ArrayList;
import java.util.Random;

public class CreateWorkOrderBeans {
	
	public ArrayList<WorkOrderBean> createWorkOrderBeans() {
		Random random = new Random();
		ArrayList<WorkOrderBean> workOrderBeans = new ArrayList();
		for (int i=0; i<10; i++) {
			WorkOrderBean workOrderBean = new WorkOrderBean();
			workOrderBean.setId(i);
			workOrderBean.setReporter("reporter:"+i);
			workOrderBean.setReport_date("date:"+i);
			workOrderBean.setField_station("fieldStation:"+i);
			workOrderBean.setDevice_id(i);
			workOrderBean.setComment("comment:"+i);
			workOrderBean.setRepair_man("repair_man:"+i);
			workOrderBean.setError_1("error1:"+i);
			workOrderBean.setError_2("error2:"+i);
			workOrderBean.setArea_manager("area_manager:"+i);
			workOrderBean.setState(0);
			workOrderBean.setImagesJson("");
			
			workOrderBeans.add(workOrderBean);
		}
		
		return workOrderBeans;
	}
}
