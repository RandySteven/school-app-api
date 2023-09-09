public enum ServiceCode {

    STUDENT_SERVICE("01"),
    TEACHER_SERVICE("02"),
    COURSE_SERVICE("03"),
    LIBRARY_SERVICE("04"),
    BORROW_SERVICE("05");

    private final String serviceCode;

    ServiceCode(String serviceCode){
        this.serviceCode = serviceCode;
    }

    public String getServiceCode(){
        return serviceCode;
    }
}
