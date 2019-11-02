import org.junit.Test;
import ru.ariona.testingSystem.domain.Question;

import static org.junit.Assert.assertEquals;

public class QuestionTest {
    @Test
    public void newQuestion() {
        Question question = new Question("Как зовут мою кошку? ; фенечка");
        assertEquals("фенечка",question.getAns());
    }
}
