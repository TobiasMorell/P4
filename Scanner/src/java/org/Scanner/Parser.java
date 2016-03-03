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

    private void acceptIt(){
        ts.CurrentToken = ts.Peek();
    }

    private void Program(){
        Robo();
        if (ts.CurrentToken._type == type.LOAD)
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
        //Parse Load WHAT DO?
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
        if (ts.CurrentToken._type == type.VOID && ts.Peek()._type == type.START && ts.PeekTwo()._type == type.EOL)
            func_body();
        else
            System.out.println("u dun goofed");
            //Error
        if (ts.CurrentToken._type == type.END && ts.Peek()._type == type.START)
            System.out.println("u dun well");

    }

    private void func() {
        if(ts.CurrentToken._type == type.TYPE && ts.Peek()._type == type.ID){
            params();
            expect(type.EOL);
            func_body();
            if (ts.CurrentToken._type == type.RETURN)
                expr();
            expect(type.END);
            expect(type.ID);
        }
        else
            System.out.println("u dun goofed");
            //Throw error
    }

    private void func_body() {

    }

    private void stmt() {

    }

    private void if_stmt() {

    }

    private void loop_stmt() {

    }

    private void func_call() {

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
