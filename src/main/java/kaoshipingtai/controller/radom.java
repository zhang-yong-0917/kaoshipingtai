//package kaoshipingtai.Controller;
//
//import kaoshipingtai.entity.TPaper;
//import kaoshipingtai.entity.TQuestion;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import javax.xml.transform.Result;
//import java.util.*;
//
//public class radom {}
//    @PostMapping("/createPaper")
//    public Result createPaper(){
//        try {
//            TPaper tPaper = new TPaper();
//            Map<String, Object> singlecolumnMap = new HashMap<>();
//            singlecolumnMap.put("data_state","Normal");
//            //获取所有的单选题
//            singlecolumnMap.put("type","单选题");
//            List<TQuestion> singleList = questionMapper.selectByMap(singlecolumnMap);
//            if(singleList.size()<20){
//                return Result.error(903,"题库中的单选题不足10道，请添加单选题到数据库");
//            }
//            //抽取单选题     填空5道
//            List<TQuestion> singleQuestions = getRandom(singleList,20);
//
//            String time = TimeUtils.dateToString(new Date());
//            String num = "EM"+time+(int) ((Math.random() * 9 + 1) * 100000);
//            String randomString = getRandomString(6);
//
//            tPaper.setCreateId(TokenUtil.getUserId());
//            tPaper.setCreateTime(new Date());
////试卷编号
//            tPaper.setPaperNum(num);
////试卷密码
//            tPaper.setPaperPwd(randomString);
//            int create = paperService.createPaper(tPaper, singleQuestions, moreQuestions, judgeQuestions, tkQuestions);
//            if (create<=0){
//                return Result.error(902,"生成试卷失败");
//            }
//            return Result.ok("生成试卷成功");
//        }catch (Exception e){
//            return Result.error(901,e.getMessage());
//        }
//    }
//    //length用户要求产生字符串的长度
//    public static String getRandomString(int length){
//        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//        Random random=new Random();
//        StringBuffer sb=new StringBuffer();
//        for(int i=0;i<length;i++){
//            int number=random.nextInt(62);
//            sb.append(str.charAt(number));
//        }
//        return sb.toString();
//    }
//    //抽取试题
//    private List<TQuestion> getRandom(List<TQuestion> questionList, int n){
//        List backList = null;
//        backList = new ArrayList<TQuestion>();
//        Random random = new Random();
//        int backSum = 0;
//        if (questionList.size() >= n) {
//            backSum = n;
//        }else {
//            backSum = questionList.size();
//        }
//        for (int i = 0; i < backSum; i++) {
////       随机数的范围为0-list.size()-1
//            int target = random.nextInt(questionList.size());
//            backList.add(questionList.get(target));
//            questionList.remove(target);
//        }
//        return backList;
//    }
