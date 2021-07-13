package pageObjects;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.GenericUtility;
import utilities.RestUtility;
import java.util.HashMap;
import static org.hamcrest.Matchers.*;


public class Apis {

    RestUtility restUtility;
    public Apis () {
        restUtility = new RestUtility();
    }

    private static String service=null;
    private static Integer countriesResponseCount=null;
    private static Response response=null;
    private static String languageCode = null;

//**********************************METHODS*****************************************

    public void retrieveAndVerifyAffilateApiHealth (String healthParameter){
        try {
            String endPoint = GenericUtility.readConfigs("affiliateFeedBaseURI");
            HashMap<String, String> parameter = new HashMap<>();
            parameter.put("health", healthParameter);
            Response response = restUtility.executeRequest(endPoint, RestUtility.RequestMethod.GET, parameter, 200);
            service =  restUtility.getResponseValue(response, "data.Service");
            Assert.assertTrue("Service key is set to ok value", service.contains("OK"));
            Assert.assertTrue("Error while execute the request",
                    Integer.parseInt(restUtility.getResponseValue(response, "status.error_code"))==0);

        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public void retrieveAFCountriesResponse (){
        try {
            String endPoint = GenericUtility.readConfigs("affiliateFeedBaseURI");
            HashMap<String, String> parameter = new HashMap<>();
            parameter.put("en", languageCode);
            parameter.put("es", languageCode);
            parameter.put("bg", languageCode);
            Response response = restUtility.executeRequest(endPoint, RestUtility.RequestMethod.GET, parameter, 200);

            service =  restUtility.getResponseValue(response, "data.Service");
            countriesResponseCount = response.body().hashCode();
            Assert.assertTrue("Check the number of countries  retrieved (i.e countries count)  is same for all 3 languages ", countriesResponseCount.equals(10));
            Assert.assertTrue("Error while execute the request",
                    Integer.parseInt(restUtility.getResponseValue(response, "status.error_code"))==0);

        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
