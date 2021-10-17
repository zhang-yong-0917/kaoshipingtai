package config;

//import com.easy.BigHomework.filter.XSSFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 这个类就是web.xml的替代品
 */
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("aaaaaaaaaaaaaaaaaaaaa");
        return new Class[]{
                ServletConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

//    @Override
//    protected Filter[] getServletFilters() {
//        return new Filter[]{
//                new CharacterEncodingFilter("UTF-8", true, true),
//                new XSSFilter("/;/scripts/*;/styles/*;/images/*")
//        };
//    }
}
