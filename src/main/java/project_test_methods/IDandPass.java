package project_test_methods;

import java.util.HashMap;

public class IDandPass {

    HashMap<String,String> logininfo= new HashMap<String,String>();

    IDandPass(){
        logininfo.put("Alex","alex123");
    }
//poate fi accesat În cadrul clasei anexate. Alte clase în același pachet ca și clasa inclusă.
   protected HashMap<String, String> getLoginIfo(){
        return logininfo;
    }
}
