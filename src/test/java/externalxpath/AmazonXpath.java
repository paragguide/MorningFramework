package externalxpath;

public class AmazonXpath 
{
	// login..
   public static final String signin = "//*[text() = 'Hello, sign in']";
   public static final String uid = "//*[@id=\"ap_email_login\"]";
   public static final String ctnbtn = "//*[@class = 'a-button-input']";
   public static final String err1 = "(//*[@class = 'a-alert-content'])[3]";
   public static final String pwd = "//*[@id=\"ap_password\"]";
   public static final String submit = "//*[@id=\"signInSubmit\"]";
   public static final String err2 = "//*[@class = 'a-list-item']";
   
   // shoping
   public static final String searchtxtbox = "//*[@id=\"twotabsearchtextbox\"]";
   public static final String productsnames = "//*[@class = 'a-size-base-plus a-color-base']";
   public static final String productslinks = "//h2[@class = 'a-size-mini a-spacing-none a-color-base s-line-clamp-2']/a";
   public static final String addtokart = "//*[@id=\"add-to-cart-button\"]";

   // forget
   public static final String forgetpwdlink = "//*[@id ='auth-fpp-link-bottom']";
   public static final String forgetuid = "//*[@id=\"ap_email\"]";
   public static final String forgetctnbtn = "//*[@id=\"continue\"]";

}
