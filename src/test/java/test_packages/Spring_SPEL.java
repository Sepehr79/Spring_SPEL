package test_packages;

import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class Spring_SPEL {
    @Test
    public void testSPEL(){
        ExpressionParser parser = new SpelExpressionParser();

        Expression expression1 = parser.parseExpression("'HELLO SPEL'");

        System.out.println(expression1.getValue());

        Expression expression2 = parser.parseExpression("'Hello World'.bytes.length");

        System.out.println(expression2.getValue());

        Expression expression3 = parser.parseExpression("new String('hello world').toUpperCase()");

        System.out.println(expression3.getValue());

        System.out.println(parser.parseExpression("'today is ' + new java.util.Date()").getValue());

        Expression expression4 = parser.parseExpression("2*5*6*7");

        System.out.println(expression4.getValue());
    }

    /**
     * using variable in SPEL
     */
    @Test
    public void setVariable(){
        Person person = new Person();
        StandardEvaluationContext context = new StandardEvaluationContext(person);

        ExpressionParser parser = new SpelExpressionParser();
        parser.parseExpression("name").setValue(context, "sepehr");
        parser.parseExpression("lastName").setValue(context, "mollaei");
        parser.parseExpression("age").setValue(context, 23);


        System.out.println(person.getAge());
    }

    static class Person{
        private String name;
        private String lastName;
        private int age;

        public Person(String name, String lastName, int age) {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
        }

        public Person() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
