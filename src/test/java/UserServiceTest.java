import org.junit.Before;
import org.junit.Test;

import javax.naming.InitialContext;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserServiceTest
{

    private static final String INITIAL_PASSWORD = "PASSWORD";
    private static final String MD5_PASSWORD = "$$$$$";
    //Write a happy-path test for the class presented below.
    // Verify that the user gets his new password, and that the updateUser() method of userDAO is called.

    private UserServiceImpl userService;
    private UserDAO userDao;
    private SecurityService securityService;
    private User user;

    @Before
    public void setUp(){
        userDao = mock(UserDAO.class);
        securityService = mock(SecurityService.class);
        user = mock(User.class);
        userService = new UserServiceImpl(userDao, securityService);
    }

    @Test
    public void userChangesPasswordIsCallingUpdateUser() throws Exception {
        when(securityService.md5(INITIAL_PASSWORD)).thenReturn(MD5_PASSWORD);
        when(user.getPassword()).thenReturn(INITIAL_PASSWORD);

        userService.assignPassword(user);

        verify(user).setPassword(MD5_PASSWORD);
        verify(userDao).updateUser(user);

    }
}
