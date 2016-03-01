/**
 * Created by Arne K. Rasmussen on 29-02-2016.
 */
public class Token {

    public enum type{
        EOF, Break, EOL, ROBOT_NAME, LOAD, NUM_DCL, ID,
        STRING_DCL, BOOL_DCL, COORD_DCL, VOID, END, HEAR,
        SIGNAL, START, IF, REPEAT, UNTIL, FOREVER, ELSE, VAL,
        PLUS, MINUS, TIMES, DIVIDE, ASSIGN, POWER, SQUARE_ROOT,
        BOOL_AND, BOOL_OR, BOOL_EQ, BOOL_GT, BOOL_LT, BOOL_GTE,
        BOOL_LTE, BOOL_LIT, COORD_LIT, STRING_LIT, TYPE, CHEST_LIT,
        BLOCK_LIT, ITEM_LIT, NPC_LIT
    }


}
