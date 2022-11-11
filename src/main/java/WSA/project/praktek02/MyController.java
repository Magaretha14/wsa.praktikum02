/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WSA.project.praktek02;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ASUS
 */
@Controller
public class MyController {
    
    @RequestMapping("/sayank")
    @ResponseBody
    public String getData(@RequestParam("nama") String text,
            @RequestParam("gambar") MultipartFile image,
            @RequestParam("tgl") 
            @DateTimeFormat (pattern="yyyy-MM-dd") Date date
    ) throws IOException{
        
        SimpleDateFormat newTanggal = new SimpleDateFormat("EE-dd-MMMM-yyyy");
        
        String tanggalku = newTanggal.format(date);
        
        String blob = Base64.encodeBase64String(image.getBytes());
        
        text = textProcess(text);
        
        return text + "<br>" + tanggalku + "<br>" + "<img src='data:image/*;base64, " + blob + " '/>";
    }
    
    private String textProcess(String nama){
        String result = "";
    
        if (nama.equals("Asroni")){
            result = nama + " Asoi";
        }
        else if (nama.equals("Haris")){
            result = nama + " Senyum dong";
        }
        else if (nama.equals("Aprilia")){
            result = nama + " Kurusin dikit";
        }
        else {
            result = nama + " cakep amat";
        }
        return result;
    }
}
