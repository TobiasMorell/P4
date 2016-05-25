.class public Simpletest1Robot
.super java/lang/Object

.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

.method public static main([Ljava/lang/String;)V
.limit locals 5
.limit stack 5
new Simpletest1Robot
dup
invokespecial Simpletest1Robot/<init>()V
invokevirtual Simpletest1Robot/START()V
return
.end method

.method public START()V
.limit stack 100
.limit locals 100
new Simpletest1Robot
dup
invokespecial Simpletest1Robot/<init>()V
ldc 13.000000
ldc 1.370000
invokevirtual Simpletest1Robot/Test1(FF)F
dup
fstore 1
fstore 10
getstatic java/lang/System/out Ljava/io/PrintStream;
fload 10
invokevirtual java/io/PrintStream/println(F)V
return
.end method

.method public Test1(FF)F
.limit stack 100
.limit locals 100
fload 1
fload 2
fadd
dup
fstore 3
fstore 10
getstatic java/lang/System/out Ljava/io/PrintStream;
fload 10
invokevirtual java/io/PrintStream/println(F)V
ldc 14.000000
ldc 3.140000
fmul
dup
fstore 4
fstore 10
getstatic java/lang/System/out Ljava/io/PrintStream;
fload 10
invokevirtual java/io/PrintStream/println(F)V
ldc 12.000000
ldc 9.000000
fsub
dup
fstore 5
fstore 10
getstatic java/lang/System/out Ljava/io/PrintStream;
fload 10
invokevirtual java/io/PrintStream/println(F)V
ldc 999.000000
ldc 3.000000
fdiv
ldc 2.000000
fmul
dup
fstore 6
fstore 10
getstatic java/lang/System/out Ljava/io/PrintStream;
fload 10
invokevirtual java/io/PrintStream/println(F)V
fload 3
freturn
return
.end method