package stepDefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class allScens {
    WebDriver driver;
    WebElement topUl;
    WebElement pagination;
    int pageNumber;
    List<WebElement> topLists;
    List<WebElement> pageNumbers;
    List<WebElement> booksonPage;
    List<WebElement> specialBooks;
    List<Integer> specialBooksPageNumber;
    public static boolean isClickable(WebElement el, WebDriver driver)
    {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
            wait.until(ExpectedConditions.elementToBeClickable(el));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    @Before
    public void beforeScenario(){
        System.out.println("All scenarios message");
    }
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:/KitapYurduGirisTest/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Given("^navigate to Website$")
    public void navigate_to_Website() throws Throwable {
        driver.get("https://www.kitapyurdu.com");
        System.out.println("Website'ye gidildi.");
    }

    @Given("^click login button$")
    public void click_login_button() throws Throwable {
        WebElement loginBtn1 = driver.findElement(By.cssSelector("div[class='menu-top-button login']")).findElement(By.cssSelector("a"));
        if(isClickable(loginBtn1,driver))
        {
            loginBtn1.click();
            System.out.println("Giriş yap butonuna tıklandı.");
        }
        else
        {
            System.out.println("Giriş yap butonuna tıklanamadı.");
        }
    }

    @Given("^type email$")
    public void type_email() throws Throwable {
        WebElement emailField = driver.findElement(By.cssSelector("input[id='login-email']"));
<<<<<<< HEAD
        emailField.sendKeys("muratcanbalci17@gmail.com");
=======
        emailField.sendKeys("testmail");
>>>>>>> c45d0df (New)
        System.out.println("Email girildi.");
    }

    @Given("^type password$")
    public void type_password() throws Throwable {
        WebElement passwordField = driver.findElement(By.cssSelector("input[id='login-password']"));
<<<<<<< HEAD
        passwordField.sendKeys("murat5462226062");
=======
        passwordField.sendKeys("testpass");
>>>>>>> c45d0df (New)
        System.out.println("Password girildi.");
    }

    @When("^click on login button$")
    public void click_on_login_button() throws Throwable {
        WebElement loginBtn2=driver.findElement(By.cssSelector("div[class='ky-form-buttons']")).findElement(By.cssSelector("button[type='submit']"));
        if(isClickable(loginBtn2,driver))
        {
            loginBtn2.click();
            System.out.println("Giriş yap butonuna tıklandı.");
        }
        else
        {
            System.out.println("Giriş yap butonuna tıklanamadı.");
        }
    }

    @Then("^verify success message$")
    public void verify_success_message() throws Throwable {
        WebElement headerTop = driver.findElement(By.xpath("//*[@id=\"header-top\"]/div/div[1]/div[1]/ul/li/a"));
        String greetingText = headerTop.getText();
        String[] greetingTextList = greetingText.split(" ");
        if(greetingTextList[0].equals("Merhaba"))
        {
            System.out.println("Login başarılı.");
        }
        else{
            System.out.println("Login başarısız.");
        }
        System.out.println(greetingText);
    }

    @Given("^Navigate to All Books Tab$")
    public void navigate_to_All_Books_Tab() throws Throwable {
        driver.get("https://www.kitapyurdu.com");
        topUl = driver.findElement(By.cssSelector("ul[class='js-ajaxCt js-bookCt']"));
        topLists = topUl.findElements(By.cssSelector("li[class='has-open-menu']"));
    }

    @Given("^Click to All Books Tab$")
    public void click_to_All_Books_Tab() throws Throwable {
        for(int i=0;i<topLists.size();i++)
        {
            if(topLists.get(i).findElement(By.cssSelector("span")).getText().equals("Tüm Kitaplar"))
            {
                topLists.get(i).findElement(By.cssSelector("span")).click();
            }
        }
    }

    @Given("^Click to Bilgisayar$")
    public void click_to_Bilgisayar() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"mainNav\"]/div[1]/ul/li[1]/div[2]/ul/li[3]/div/div[1]/div/ul[1]/li[5]/a")).click();
        System.out.println("Bilgisayara tıklandı.");
    }

    @Given("^Click to List all products$")
    public void click_to_List_all_products() throws Throwable {
        driver.findElement(By.id("list_product_carousel_best_sell-view-all")).click();
    }

    @Given("^Find number of total books$")
    public void find_number_of_total_books() throws Throwable {
        pagination = driver.findElement(By.cssSelector("div[class='pagination']"));
        String pageinfo = pagination.findElement(By.className("results")).getText();
        String[] pageinfoList = pageinfo.split("\\(");
        pageinfoList = pageinfoList[1].split("\\)");
        pageinfoList = pageinfoList[0].split(" ");
        pageNumber = Integer.parseInt(pageinfoList[0]);
        System.out.println("Page number found: "+pageNumber);
    }

    @Given("^Add all books about special word to list and click to tabs according to number$")
    public void add_all_books_about_special_word_to_list_and_click_to_tabs_according_to_number() throws Throwable {
        try {
            booksonPage = driver.findElements(By.cssSelector("div[class='product-cr']"));
            for(int b=0;b<booksonPage.size();b++)
            {
                String baslik = booksonPage.get(b).findElement(By.cssSelector("div[class='name ellipsis']")).getAttribute("title").toLowerCase();
                if(baslik.contains("python"))
                {
                    specialBooks.add(booksonPage.get(b));
                    specialBooksPageNumber.add(b);
                }
            }
            for(int i=1;i<pageNumber;i++)
            {
                pageNumbers = pagination.findElement(By.cssSelector("div[class='links']")).findElements(By.cssSelector("a"));
/*
            for(int deleter=0;deleter<2;deleter++)
            {
                int indexOfLastElement = pageNumbers.size() - 1;
                pageNumbers.remove(indexOfLastElement);
            }
            */
                pageNumbers.get(i).click();
                Thread.sleep(2000);
                booksonPage = driver.findElements(By.cssSelector("div[class='product-cr']"));
                for(int b=0;b<booksonPage.size();b++)
                {
                    String baslik = booksonPage.get(b).findElement(By.cssSelector("div[class='name ellipsis']")).getAttribute("title").toLowerCase();
                    System.out.println("Başlık: "+baslik);
                    WebElement chosenBook = booksonPage.get(b);
                    if(baslik.contains("python"))
                    {
                        specialBooks.add(chosenBook);
                        specialBooksPageNumber.add(i);
                    }
                }
            }
        }catch (Exception e)
        {
            System.out.println("Hata: "+e.toString());
        }
    }

    @Given("^Select a random one$")
    public void select_a_random_one() throws Throwable {
        Random rand = new Random();
        int randomNum = 1 + rand.nextInt((specialBooks.size() - 1) + 1);
        int specialpage = (int) specialBooksPageNumber.get(randomNum-1);

        int currentPage = Integer.parseInt(pagination.findElement(By.cssSelector("div[class='links']")).findElement(By.cssSelector("b")).getText());
        if(currentPage != specialpage)
        {
            pageNumbers.get((int)specialBooksPageNumber.get(randomNum-1)).click();
            Thread.sleep(2000);
            specialBooks.get(randomNum-1).findElement(By.cssSelector("a")).click();
        }
        else if(currentPage == specialpage)
        {
            specialBooks.get(randomNum-1).findElement(By.cssSelector("a")).click();
        }
        else{
            System.out.println("Random kitap seçimi hata.");
        }
    }

    @Given("^Find its price$")
    public void find_its_price() throws Throwable {

    }

    @Given("^If its price under our total money$")
    public void if_its_price_under_our_total_money() throws Throwable {

    }

    @Given("^Click to add basket and verify success message$")
    public void click_to_add_basket_and_verify_success_message() throws Throwable {

    }

    @Given("^Click to my basket button$")
    public void click_to_my_basket_button() throws Throwable {

    }

    @Given("^Find to book$")
    public void find_to_book() throws Throwable {

    }

    @When("^Click delete button$")
    public void click_delete_button() throws Throwable {

    }

    @Then("^Control info button$")
    public void control_info_button() throws Throwable {

    }


}
