package springbook.user.exception;

import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.sql.SQLException;

// 예외 포장
public class Exception_ex5 {
    /* try{
        OrderHome orderHome = EJBHomeFactory.getInstance().getOrderHome();
        Order order = orderHome.findByPrimaryKey(Integer id);
    } catch (NamingException ne) {
        throw new EJBException(ne);
    } catch (SQLException se) {
        throw new EJBException(se);
    } catch (RemoteException re) {
        throw new EJBException(re);
    }
    */
}
