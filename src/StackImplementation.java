import java.util.Stack;

public class StackImplementation {
    private StringBuilder text = new StringBuilder();
    private Stack<TextOperation> stack = new Stack<>();

    public void addText(char character) {
        text.append(character);
        stack.push(new TextOperation("add", character));
        display();
    }

    public void deleteText() {
        if (!text.isEmpty()) {
            char lastCharacter = text.charAt(text.length()-1);
            text.deleteCharAt(text.length()-1);
            stack.push(new TextOperation("delete", lastCharacter));
        }
        display();
    }

    public void undo() {
        if (!stack.isEmpty()) {
            TextOperation lastOperation = stack.pop();
            if (lastOperation.operation().equals("add")) {
                text.deleteCharAt(text.length()-1);
            } else if (lastOperation.operation().equals("delete")) {
                text.append(lastOperation.character());
            }
        }
        display();
    }

    public void display() {
        System.out.println(text.toString());
    }

    public static void main(String[] args) {
        StackImplementation implementation = new StackImplementation();
        implementation.addText('H');
        implementation.addText('e');
        implementation.addText('l');
        implementation.addText('l');
        implementation.addText('i');
        implementation.undo();
        implementation.addText('0');
        implementation.deleteText();
        implementation.addText('o');
    }
}
