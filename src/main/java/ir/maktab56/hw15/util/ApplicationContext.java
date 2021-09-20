//package ir.maktab56.hw15.util;
//
//import ir.maktab56.hw15.repository.UserRepository;
//import ir.maktab56.hw15.repository.imp.UserRepositoryImpl;
//import ir.maktab56.hw15.service.UserService;
//import ir.maktab56.hw15.service.imp.UserServiceImpl;
//
//import javax.persistence.EntityManager;
//
//public class ApplicationContext {
//
//    private static final UserRepository userRepository;
//
//    private static final UserService userService;
//
//
//
//
//    private ApplicationContext() {
//    }
//
//    static {
//        EntityManager entityManager = HibernateUtil.getEntityMangerFactory().createEntityManager();
//        userRepository = new UserRepositoryImpl(entityManager);
//        userService = new UserServiceImpl(userRepository);
//    }
//
//    public static UserService getUserService() {
//        return userService;
//    }
//    public static TwittService getTwittService() {
//        return twittService;
//    }
//}