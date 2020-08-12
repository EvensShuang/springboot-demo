package com.shuang.learn.design;

public class 模板方法模式 {
    public static void main(String[] args) {
        StudyAboard studyAboard = new StudyAmerica();
        studyAboard.templateMethod();
    }
}

//出国留学 - 抽象类
abstract class StudyAboard {
    //模范方法
    public void templateMethod(){
        lookingForSchool(); //1.获取学校资料-抽象方法
        applyForEnrol();//2.提出入学申请-抽象方法
        applayForPassport();//3.办理因私申请护照,出境卡和公证-基本方法
        applyForVisa();//4.申请签证-基本方法
        readyGoAbroad();//5.体检、订机票、准备行装-基本方法
        arriving();//6.抵达-抽象方法
    }

    //1.获取学校资料-抽象方法
    public abstract void lookingForSchool();

    //2.提出入学申请-抽象方法
    public abstract void applyForEnrol();

    //3.办理因私申请护照,出境卡和公证-基本方法
    public void applayForPassport(){
        System.out.println("三.办理因私出国护照、出境卡和公证：");
        System.out.println("  1）持录取通知书、本人户口簿或身份证向户口所在地公安机关申请办理因私出国护照和出境卡。");
        System.out.println("  2）办理出生公证书，学历、学位和成绩公证，经历证书，亲属关系公证，经济担保公证。");
    }

    //4.申请签证-基本方法
    public void applyForVisa(){
        System.out.println("四.申请签证：");
        System.out.println("  1）准备申请国外境签证所需的各种资料，包括个人学历、成绩单、工作经历的证明；个人及家庭收入、资金和财产证明；家庭成员的关系证明等；");
        System.out.println("  2）向拟留学国家驻华使(领)馆申请入境签证。申请时需按要求填写有关表格，递交必需的证明材料，缴纳签证。有的国家(比如美国、英国、加拿大等)在申请签证时会要求申请人前往使(领)馆进行面试。");
    }

    //5.体检、订机票、准备行装-基本方法
    public void readyGoAbroad(){
        System.out.println("五.体检、订机票、准备行装：");
        System.out.println("  1）进行身体检查、免疫检查和接种传染病疫苗；");
        System.out.println("  2）确定机票时间、航班和转机地点。");
    }

    //6.抵达-抽象方法
    public abstract void arriving();
}

class StudyAmerica extends StudyAboard{
    @Override
    public void lookingForSchool() {
        // TODO Auto-generated method stub
        System.out.println("一.索取学校以下资料：");
        System.out.println("  1）对留学意向国家的政治、经济、文化背景和教育体制、学术水平进行较为全面的了解；");
        System.out.println("  2）全面了解和掌握国外学校的情况，包括历史、学费、学制、专业、师资配备、教学设施、学术地位、学生人数等；");
        System.out.println("  3）了解该学校的住宿、交通、医疗保险情况如何；");
        System.out.println("  4）该学校在中国是否有授权代理招生的留学中介公司？");
        System.out.println("  5）掌握留学签证情况；");
        System.out.println("  6）该国政府是否允许留学生合法打工？");
        System.out.println("  8）毕业之后可否移民？");
        System.out.println("  9）文凭是否受到我国认可？");
    }
    @Override
    public void applyForEnrol() {
        // TODO Auto-generated method stub
        System.out.println("二.入学申请：");
        System.out.println("  1）填写报名表；");
        System.out.println("  2）将报名表、个人学历证明、最近的学习成绩单、推荐信、个人简历、托福或雅思语言考试成绩单等资料寄往所申请的学校；");
        System.out.println("  3）为了给签证办理留有充裕的时间，建议越早申请越好，一般提前1年就比较从容。");
    }
    @Override
    public void arriving() {
        // TODO Auto-generated method stub
        System.out.println("六.抵达目标学校：");
        System.out.println("  1）安排住宿；");
        System.out.println("  2）了解校园及周边环境。");
    }


}