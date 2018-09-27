package springbook.user.exception;


import java.sql.SQLException;

public class Exception_ex4 {
    /* 중첩예외 1
    catch(SQLException e) {
        ...
        throw DulplicateUserIdException(e);
    }
    */

    /* 중첩예외 2
    catch(SQLException e) {
        ...
        throw DuplicateUserIdException().initCause(e);
    }
    */
}
