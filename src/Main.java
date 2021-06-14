/**
 * Given a sequence of moves for a robot, check if the sequence is circular or not.
 * A sequence of moves is circular if first and last positions of robot are same.
 * A move can be one of the following.
 *   G - Go one unit
 *   L - Turn left
 *   R - Turn right
 *
 * Examples:
 *
 * Input: path[] = "GLGLGLG"
 * Output: Given sequence of moves is circular
 *
 * Input: path[] = "GLLG"
 * Output: Given sequence of moves is circular
 */

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.isCircular("GLGLGLGRG") ? "Is circular" : "not circular");
    }

    private boolean isCircular(String input) {
        char[] arr = input.toCharArray();
        Cursor robot = new Cursor();

        for (char c : arr) {
            switch(c) {
                case 'G':
                    robot.goOneUnit();
                    break;
                case 'L':
                    robot.turnLeft();
                    break;
                case 'R':
                    robot.turnRight();
                    break;
            }

            System.out.println("Now at " + robot.getXY());
        }
        boolean result = robot.getXY().equals("0,0");
        System.out.println(result);
        return result;
    }

    enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    static class Cursor {

        private int x;
        private int y;
        private Direction dir;

        public Cursor() {
            this.x = 0;
            this.y = 0;
            this.dir = Direction.UP;
        }

        public String getXY() {
            return this.x + "," + this.y;
        }

        public void goOneUnit() {
            switch(this.dir) {
                case UP:
                    this.y++;
                    break;
                case DOWN:
                    this.y--;
                    break;
                case LEFT:
                    this.x--;
                    break;
                case RIGHT:
                    this.x++;
                    break;
            }
        }

        public Direction turnLeft() {
            switch(this.dir) {
                case UP:
                    this.dir = Direction.LEFT;
                    break;
                case DOWN:
                    this.dir = Direction.RIGHT;
                    break;
                case LEFT:
                    this.dir = Direction.DOWN;
                    break;
                case RIGHT:
                    this.dir = Direction.UP;
                    break;
            }

            return this.dir;
        }

        public Direction turnRight() {
            switch(this.dir) {
                case UP:
                    this.dir = Direction.RIGHT;
                    break;
                case DOWN:
                    this.dir = Direction.LEFT;
                    break;
                case LEFT:
                    this.dir = Direction.UP;
                    break;
                case RIGHT:
                    this.dir = Direction.DOWN;
                    break;
            }

            return this.dir;
        }
    }
}
