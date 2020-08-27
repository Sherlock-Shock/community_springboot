package com.lee.community;

import com.lee.community.mapper.BbuildingMapper;
import com.lee.community.mapper.BhouseMapper;
import com.lee.community.mapper.BunitMapper;
import com.lee.community.mapper.UsersMapper;
import com.lee.community.pojo.Bhouse;
import com.lee.community.pojo.Student;
import com.lee.community.pojo.Users;
import com.lee.community.service.AuthService;
import com.lee.community.service.CrawlerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.List;
import java.util.Stack;

@SpringBootTest
class CommunityApplicationTests {


    @Autowired
    UsersMapper usersMapper;
    @Autowired
    BunitMapper bunitMapper;
    @Autowired
    BhouseMapper bouseMapper;
    @Autowired
    BbuildingMapper bbuildingMapper;
    @Autowired
    AuthService authService;
    @Autowired
    CrawlerService crawlerService;

    @Test
    void TestMN(){
        List<Student> stuAndTea = usersMapper.findStuAndTea();
        stuAndTea.forEach(s->{
            System.out.println(s.toString());
        });
    }

    @Test
    void TestStream() throws FileNotFoundException,IOException{
        File file = new File("src/aaa.txt");
        OutputStream outputStream = new FileOutputStream(file,true);
        outputStream.write(new String("hello world").getBytes());
        outputStream.close();

        InputStream inputStream = new FileInputStream(file);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//        String line =null;
//        while((line = bufferedReader.readLine())!=null){
//            System.out.println(line);
//        }
        StringBuffer str = new StringBuffer();
        char[] buf = new char[1024];
        FileReader fileReader = new FileReader(file);
        while(fileReader.read(buf)>0){
           str.append(buf);
        }
        System.out.println(str);

    }
    @Test
    void testCraw(){
        crawlerService.csdnBlog();
    }

    @Test
    void contextLoads() {
        String post = "23786";
        String random = "63782";
       char[] randomSplit = random.toCharArray();
//        Stack<Character> sk = new Stack<Character>();
//        for (int i =0;i<postSplit.length;i++){
//            if (Integer.parseInt(String.valueOf(postSplit[i]))%2==0){
//                sk.push(postSplit[i]);
//            }
//        }
//        for (int i =0;i<postSplit.length;i++){
//            if (Integer.parseInt(String.valueOf(postSplit[i]))%2==0){
//                char ch = sk.pop();
//                postSplit[i]=ch;
//            }
//        }
//        for (int i =0;i<postSplit.length;i++){
//            System.out.println(postSplit[i]);
//        }
        int h =0;
        int w =randomSplit.length-1;
//        while (h!=w){
//            while (Integer.parseInt(String.valueOf(randomSplit[h]))%2!=0){h++;}
//            while (Integer.parseInt(String.valueOf(randomSplit[w]))%2!=0){w--;}
//
//            if (h==w){
//                break;
//            }
//            char temp=randomSplit[h];
//            randomSplit[h]=randomSplit[w];
//            randomSplit[w]=temp;
//            h++;
//            w--;
//        }
        while(h < w){
            if(h<w && Integer.parseInt(String.valueOf(randomSplit[h]))%2!=0){
                h++;
                continue;
            }
            if (h<w && Integer.parseInt(String.valueOf(randomSplit[w]))%2!=0){
                w--;
                continue;
            }
            if(h<w){
                char temp=randomSplit[h];
                randomSplit[h]=randomSplit[w];
                randomSplit[w]=temp;
                h++;
                w--;
            }


        }

        for (int i =0;i<randomSplit.length;i++){
            System.out.println(randomSplit[i]);
        }
        if (post.equals(String.valueOf(randomSplit))){
            System.out.println("胜利");
        }else{
            System.out.println("失败");
        }

    }

}
