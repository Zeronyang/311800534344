package service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 题目判错类
 */
public class Check {

    /**
     * 检查用户输入的答案是否正确
     * @param userAnswerPath 用户答案文件名
     * @param answerPath 生成的标准答案文件名
     * @param gradePath 成绩文件名
     *
     */
    public static void check(String userAnswerPath, String answerPath,String gradePath) throws IOException {
        File userAnswerFile = new File(userAnswerPath);
        File answerFile = new File(answerPath);
        File gradeFile = new File(gradePath);
        if (!userAnswerFile.exists() || !answerFile.exists() || !gradeFile.exists()) {
            throw new IOException("找不到文件");
        }
        List<String> wrongList = new ArrayList<>();// 错误题目序号集合
        List<String> correctList = new ArrayList<>();// 正确题目序号集合

        BufferedReader userAnswerReader = new BufferedReader(new FileReader(userAnswerFile));
        BufferedReader answerReader = new BufferedReader(new FileReader(answerFile));
        BufferedWriter gradeWriter = new BufferedWriter(new FileWriter(gradeFile));
        String userAnswer, answer;
        int count = 0;
        while ((answer = answerReader.readLine()) != null) {
            if ((userAnswer = userAnswerReader.readLine()) != null) {
                String[] str1 = userAnswer.split("\\.");
                String[] str2 = answer.split("\\.");
                //从两份答案的每个题号后面的答案进行对比
                if ((str1[1].trim()).equals(str2[1].trim())) {
                    correctList.add(str1[0]);
                } else {
                    wrongList.add(str2[0]);
                }
            } else {
                count++;
                wrongList.add(count + "");
            }
        }
        StringBuilder stringBuilder = new StringBuilder("correct:");
        stringBuilder.append(correctList.size()).append("(");
        printList(stringBuilder,correctList);
        stringBuilder.append(")\n");
        stringBuilder.append("wrong:").append(wrongList.size()).append("(");
        printList(stringBuilder,wrongList);
        stringBuilder.append(")\n");
        gradeWriter.write(stringBuilder.toString());
        System.out.println(stringBuilder.toString());

        userAnswerReader.close();
        answerReader.close();
        gradeWriter.flush();
        gradeWriter.close();
    }
    public static void printList(StringBuilder stringBuilder, List<String> list){
        for (int i = 0; i < list.size(); i++){
            if(i == list.size() - 1){
                stringBuilder.append(list.get(i));
            }else{
                stringBuilder.append(list.get(i)).append(",");
            }
        }
    }
}