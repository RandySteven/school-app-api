public enum PortCode {
    STUDENT_SERVICE(8081),
    TEACHER_SERVICE(8082),
    COURSE_SERVICE(8083),
    LIBRARY_SERVICE(8084),
    BORROW_SERVICE(8085);

    private int portCode;

    PortCode(int portCode){
        this.portCode = portCode;
    }

    public int getPortCode(){
        return portCode;
    }
}
