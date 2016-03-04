package org.Scanner;
import org.Scanner.Token.*;

/**
 * Created by Tidsfordriv on 03/03/16.
 */
public class Parser {

    TokenStream ts;

    public Parser(){
        ts = new TokenStream();
    }

    private void expect(Token.type expectedTokenType){
        if (ts.CurrentToken._type == expectedTokenType)
            ts.CurrentToken = ts.Peek();
        else
            System.out.println("u dun goofed");
            //Insert error here
    }

    private void expect(Token.type expectedTokenType, Token.type expectedFollowingToken){
        if (ts.CurrentToken._type == expectedTokenType && ts.Peek()._type == expectedFollowingToken)
            ts.CurrentToken = ts.PeekTwo();
        else
            System.out.println("u dun goofed");
        //Insert error here
    }

    private void expect(Token.type expectedFirstToken, Token.type expectedSecondToken, Token.type expectedThirdToken){
        if (ts.CurrentToken._type == expectedFirstToken && ts.Peek()._type == expectedSecondToken && ts.PeekTwo()._type == expectedThirdToken) {
            ts.CurrentToken = ts.PeekTwo();
            ts.CurrentToken = ts.Peek();
        }
        else
            System.out.println("u dun goofed");
        //Insert error here
    }

    private void acceptIt(){
        ts.CurrentToken = ts.Peek();
    }

    private boolean isDCL(type t){
        if (t == type.BOOL_DCL || t == type.REF_DCL || t == type.NUM_DCL || t == type.COORD_DCL || t == type.STRING_DCL)
            return true;
        return false;
    }

    private boolean isSTMT(type t){
        if (t == type.IF || t == type.REPEAT || t == type.FOREVER || t == type.SIGNAL)
            return true;
        return false;
    }

    private void Program(){
        Robo();
        Load();
        dcl();
        start_func();
        while(ts.CurrentToken._type != type.EOF)
            func();
        expect(type.EOF);
    }

    private void Robo(){
        if(ts.CurrentToken._type == type.ROBOT_NAME)
            expect(type.ROBOT_NAME);
        else
            System.out.println("u dun goofed");
    }

    private void Load(){
        /*while(ts.Peek()._type == type.LOAD || ts.Peek()._type == type.ID || ts.Peek()._type == type.EOL){
            Do something
        }*/
    }

    private void dcl(){
        boolean declaring = true;
        while(declaring)
            switch (ts.CurrentToken._type){
                case NUM_DCL:{
                    num_dcl();
                    //Stuff it do.
                }
                break;
                case REF_DCL:{
                    ref_dcl();
                    //Stuff it do
                }
                break;
                case STRING_DCL:{
                    string_dcl();
                    //Stuff it do
                }
                break;
                case BOOL_DCL:{
                    bool_dcl();
                    //Stuff it do
                }
                break;
                case COORD_DCL:{
                    coord_dcl();
                    //Stuff it do
                }
                break;
                default:
                    declaring = false;
                break;
            }
    }

    private void num_dcl(){
        //Parse num_dcl
    }

    private void ref_dcl(){
        //Parse ref_dcl
    }

    private void string_dcl(){
        //Parse string_dcl
    }

    private void bool_dcl() {
        //Parse bool_dcl
    }

    private void coord_dcl() {

    }

    private void start_func() {
        if (ts.CurrentToken._type == type.VOID && ts.Peek()._type == type.START && ts.PeekTwo()._type == type.EOL){
            ts.CurrentToken = ts.PeekTwo();
            acceptIt();
            func_body();
        }
        else
            System.out.println("u dun goofed");
            //Error
        if (ts.CurrentToken._type == type.END && ts.Peek()._type == type.START)
            System.out.println("u dun well");

    }

    private void func() {
        if(ts.CurrentToken._type == type.TYPE && ts.Peek()._type == type.ID){
            acceptIt();
            acceptIt();
            params();
            expect(type.EOL);
            func_body();
            if (ts.CurrentToken._type == type.RETURN)
                expr();
            expect(type.END);
            expect(type.ID);
        }
        else if(ts.CurrentToken._type == type.HEAR && ts.Peek()._type == type.STRING_LIT){
            acceptIt();
            acceptIt();
            params();
            func_body();
            expect(type.END);
            expect(type.HEAR);
        }
        else
            System.out.println("u dun goofed");
            //Throw error
    }

    private void func_body() {
        while (ts.CurrentToken._type != type.END){
            if(isDCL(ts.CurrentToken._type))
                dcl();
            else if (isSTMT(ts.CurrentToken._type))
                stmt();
            else
                System.out.println("u dun goofed");
                //Error
            expect(type.EOL);
        }
    }

    private void stmt() {
        switch(ts.CurrentToken._type){
            case IF:{
                acceptIt();
                if_stmt();
                //Stuff it do
            }
            break;
            case REPEAT:{
                acceptIt();
                loop_stmt();
                //Stuff it do
            }
            break;
            case FOREVER:{
                acceptIt();
                loop_stmt();
            }
            break;
            case SIGNAL:{
                acceptIt();
                sig_stmt();
            }
            break;
            case FUNC_CALL:{
                acceptIt();
                func_call();
            }
            break;
            default:{
                //Errors
            }
            break;
        }
    }

    private void if_stmt() {
        expect(type.IF);
        cond();
        expect(type.EOL);
        func_body();
        expect(type.END, type.IF);
        while(ts.CurrentToken._type == type.ELSE && ts.Peek()._type == type.IF){
            expect(type.ELSE, type.IF);
            func_body();
            expect(type.END, type.ELSE, type.IF);
        }
        if(ts.CurrentToken._type == type.ELSE){
            expect(type.ELSE);
            func_body();
            expect(type.END, type.ELSE);
        }
    }

    private void loop_stmt() {
        if(ts.CurrentToken._type == type.REPEAT) {
            expect(type.REPEAT, type.UNTIL);
            cond();
            expect(type.EOL);
            func_body();
            expect(type.END, type.REPEAT);
        }
        else if(ts.CurrentToken._type == type.FOREVER){
            expect(type.FOREVER, type.EOL);
            func_body();
            expect(type.END, type.FOREVER);
        }
        else
            System.out.println("u dun goofed");
            //Error
    }

    private void func_call() {
        expect(type.ID);
        if(ts.CurrentToken._type == type.DOT){
            expect(type.DOT, type.ID);
            args();
        }
        else
            args();
        expect(type.EOL);

    }

    private void sig_stmt() {

    }

    private void expr() {

    }

    private void term() {

    }

    private void factor() {

    }

    private void exp() {

    }

    private void cond() {

    }

    private void bool_op() {

    }

    private void bool_end() {

    }

    private void args() {

    }

    private void params() {

    }

}
