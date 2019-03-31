package aop;

public class RuntimeLoggingDemo {

    public static void main(String[] args) throws Exception {

        AnnotationBootstrapper bootstraper = new AnnotationBootstrapper();
        RuntimeLoggingDemo demo = bootstraper.bootstrap(RuntimeLoggingDemo.class);
        demo.notAnnotated();
        demo.annontated();
        demo.annontated();
        demo.notAnnotated();

    }

    @AnnotateMe
    public void annontated() {
        System.out.println("^^ Annotation");
    }

    public void notAnnotated() {
        System.out.println("No annotation :(");
    }


}

