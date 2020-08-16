package gladiator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import com.project.dao.GenericDao;
import com.project.entity.Route;
import com.project.entity.RouteSchedule;

public class RouteTest {
	
	@Test
	public void addroute() {
		GenericDao dao = new GenericDao();
		
		Route rut5 = new Route();
		rut5.setId(06);
		rut5.setsource("Delhi");
		rut5.setdest("Dehradun");
	
		dao.save(rut5);
		
	}

	@Test
	public void addScheduletoRoute() {

		GenericDao dao = new GenericDao();
		Route rut = dao.fetch(Route.class,6);

		RouteSchedule rs = new RouteSchedule();
		rs.setSid(001);
		rs.setDate(LocalDate.of(2020, 8, 19));
		rs.setDepttime(LocalTime.of(8, 00));
		rs.setArrtime(LocalTime.of(11, 00));
		rs.setRoute(rut);
		dao.save(rs);

	}
	
	@Test
	public void addRouteAlongWithSchedule() {
		GenericDao dao = new GenericDao();
		
		Route rut = new Route();
		rut.setId(10);
		rut.setsource("Mumbai");
		rut.setdest("Pune");
		
		
		List<RouteSchedule> routeschedule = new ArrayList<RouteSchedule>();
		
		RouteSchedule rs = new RouteSchedule();
		rs.setSid(003);
		rs.setDate(LocalDate.of(2020, 8, 20));
		rs.setDepttime(LocalTime.of(8, 00));
		rs.setArrtime(LocalTime.of(11, 00));
		rs.setRoute(rut);
		
		routeschedule.add(rs);
		rut.setRouteschedules(routeschedule);
		
		dao.save(rut);
	}
	

}
