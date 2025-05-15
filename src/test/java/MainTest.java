package test.java;

/**
 * DO NOT DISTRIBUTE.
 *
 * This code is intended to support the education of students associated
 * with the Tandy School of Computer Science at the University of Tulsa.
 * It is not intended for distribution and should remain within private
 * repositories that belong to Tandy faculty, students, and/or alumni.
 */
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.ByteArrayOutputStream;
import main.java.Main;
import org.junit.After;
import org.junit.Test;
import test.java.TUGrader.DisplayName;
import test.java.TUGrader.TestGroup;

/**
 * This class provides a set of unit tests for the
 * {@link Main} class using the JUnit testing
 * framework, the Java Reflection API, and
 * the TUGrader.
 */
public class MainTest {

  // **************************************************
  // Setup and cleanup
  // **************************************************

  @After
  public void cleanup() {
    TUGrader.resetStdIO();
  }

  // **************************************************
  // Helper methods
  // **************************************************

  public String getOutput(String input) {
    ByteArrayOutputStream stdout = TUGrader.captureStdout();
    TUGrader.flushToStdin(input);
    Main.main(new String[0]);
    return stdout.toString().trim();
  }

  // **************************************************
  // Sample Tests
  // **************************************************

  @Test
  @TestGroup({"sample", "test1"})
  @DisplayName("should compute the first sample test case")
  public void sampleTest1() {
    String stdin = "8\nzhofrph$\n3\n0\n";
    String actual = getOutput(stdin);
    String expected = "welcome!";
    assertThat("incorrect decode", actual, is(equalTo(expected)));
  }

  @Test
  @TestGroup({"sample", "test2"})
  @DisplayName("should compute the second sample test case")
  public void sampleTest2() {
    String stdin = "12\nOlssv3'^vysk\n7\n0\n";
    String actual = getOutput(stdin);
    String expected = "Hello, World";
    assertThat("incorrect decode", actual, is(equalTo(expected)));
  }

  @Test
  @TestGroup({"sample", "test8"})
  @DisplayName("should compute the third sample test case")
  public void sampleTest3() {
    String stdin = "8\n!nufrph$\n3\n1\n0 3\n6\n";
    String actual = getOutput(stdin);
    String expected = "welcome!";
    assertThat("incorrect decode", actual, is(equalTo(expected)));
  }

  @Test
  @TestGroup({"sample", "test9"})
  @DisplayName("should compute the fourth sample test case")
  public void sampleTest4() {
    String stdin = "12\nWt{{~6*bz}wo\n10\n2\n0 5\n5\n7 12\n1\n";
    String actual = getOutput(stdin);
    String expected = "Hello, World";
    assertThat("incorrect decode", actual, is(equalTo(expected)));
  }

  // **************************************************
  // Algorithm Tests
  // **************************************************

  @Test
  @TestGroup({"secret", "test3"})
  @DisplayName("should decode a long message with a small offset")
  public void algoTest3() {
    String stdin = "256\n}Ups}Z#|w![UP YSPn[}U&^sMY}OX\"`oU\\TXopW~WwUmaMWOU`sq[Xnd{TOutmv!VXNxy^R]c^blNWoOnS[Ny}&Mp[oyZN$RqS{zN_#scvy!QwmsRQr]O|&zlLrtZW[wWWbcnmrz]||b{$}tY\\vpN^_Weu[vNTbnZpZX_rtTZPeLTNde #$qRm`Qv| [__}SS`^Vpyaq&&b]~P_&\\RYrRyZy[bqTtrNa%pOtNtQnw^&}a^y}QZ[N]TuNl]}l#ORu\n11\n0\n";
    String actual = getOutput(stdin);
    String expected = "rJehrOwqluPJEtNHEcPrJzShBNrDMvUdJQIMdeLsLlJbVBLDJUhfPMcYpIDjibkuKMCmnSGRXSWaCLdDcHPCnrzBePdnOCxGfHpoCTwhXknuFlbhGFgRDqzoaAgiOLPlLLWXcbgoRqqWpxriNQkeCSTLZjPkCIWcOeOMTgiIOEZAICYZtwxfGbUFkqtPTTrHHUSKenVfzzWRsETzQGNgGnOnPWfIigCVyeDiCiFclSzrVSnrFOPCRIjCaRrawDGj";
    assertThat("incorrect decode", actual, is(equalTo(expected)));
  }

  @Test
  @TestGroup({"secret", "test4"})
  @DisplayName("should decode a long message with a wraparound")
  public void algoTest4() {
    String stdin = "312\nmCB~9}%8x -7==Fxy0?}@n~F>:qD;B%|x:D#%}1v@&>2|qxmrmB4xq12=z zowAuB\"v-u/}8A;/$<u\"A@1032nv7 1yCw@\"$#~2.!<6.@-;: 9|xxo72>!}:|u9-\"4#/z-oyB4s/!1%:.D>w:25#wB3pFr<5nqurxn&7oo&sr -t163}r6m~?.4?-9#./y3@rFqpA5=EB1BDt3&9n2<54p!CAsmCqlv-9z\"B905@#C {A?CA{F4.\"{ts17/n9\"vCs=7%v!qr3v!8&p8?8}7?\"v|3} xm5v6osC<E#{6n=Dwyzp|>xC}?76v.\n43\n0\n";
    String actual = getOutput(stdin);
    String expected = "BwvSmRYlMTakqqzMNdsRtCSzrnFxovYQMnxWYReKtZrfQFMBGBvhMFefqOTODLuJvVKaJcRluocXpJVutedgfCKkTeNwLtVXWSfbUpjbtaonTmQMMDkfrURnQJmaVhWcOaDNvhHcUeYnbxrLnfiWLvgEzGpiCFJGMCZkDDZHGTaIejgRGjBSsbhsamWbcNgtGzFEuiqyvevxIgZmCfpihEUwuHBwFAKamOVvmditWwTPuswuPzhbVPIHekcCmVKwHqkYKUFGgKUlZElslRksVKQgRTMBiKjDHwpyWPjCqxLNOEQrMwRskjKb";
    assertThat("incorrect decode", actual, is(equalTo(expected)));
  }

  @Test
  @TestGroup({"secret", "test5"})
  @DisplayName("should decode a long message with special characters")
  public void algoTest5() {
    String stdin = "194\n'\\6a0gV{vUpk&&A3pMxAd)a@(_8{/6|amL7Amnhdh9*(:Ur,(%\"L<#$T~!,/<x>0RyYb'|9|;^`4bciZy>|{,xw7\"[kxy_'S3@(k6:qz^Zl@\"M$4;,\\b2U\\]rhQggsc/n,nt7];Z,~>O'&%94~*Qz@sL7wRv$--0/urr4u25c/\\ZpX+Yrww|niS=^l,k9O]e||\n18\n0\n";
    String actual = getOutput(stdin);
    String expected = "tJ$O}UDidC^Yss/!^;f/RvO.uM&i|$jO[:%/[\\VRV'wu(C`yuro:*pqBlny|*f,}@gGPtj'j)LN\"PQWHg,jiyfe%oIYfgMtA!.uY$(_hLHZ.o;q\")yJP CJK`V?UUaQ|\\y\\b%K)Hyl,=tsr'\"lw?h.a:%e@dqzz}|c``\"c #Q|JH^FxG`eej\\WA+LZyY'=KSjj";
    assertThat("incorrect decode", actual, is(equalTo(expected)));
  }

  @Test
  @TestGroup({"secret", "test6"})
  @DisplayName("should decode a long message with numbers")
  public void algoTest6() {
    String stdin = "512\n\"SLLbRa|lcwtT><Xz;%%^$\"sOt[<%s%Zv>L~ @sqU$ZLBS^Uan[@W]r}$;Xqqnn?SNzTZ@`T!M\"]~`M=P|uSbX]ZmR@#}Rmy_Sm>>]#mMsV%cp<Y$cuu&Mcll]M<LuoB<;vd#yb]V}s@_>PMzxtTL= BSnxs~t\"V|?mPMDSb]T\"#^s<$==WYYPCA]mB?tnnWBrSwzaUdACb\"qNVSR&ZQ@<Xc>W%lYCyr>#lo#qxb&&~;wN}]QaLR]~YbutPVxb>~TcSdpm\"OnTWlD%\\|bm`dzB<U!XaT \\@tnNuuOP!}LPX[a $O\\@]C%\"Dtc&coC%vVOCSB?@NU a^]`cO_`UZC>rax||]Tu]PW=MBNl[zLXY;z@[%m>s@|?YLSz?uqvvdn%S>|<TV#cq`Vn<~]OQ?~lDpRLxr;S{|{_<WRVR=d^Y~#C?$d]V&= [d<Q>nLOu O_!$;n&Cw_%;vX;~O[#R_t[Q_cdz}{>>=!Q;qLp\"<u@py_lLAL]uMXXq@B!{\"\"sSw\n11\n0\n";
    String actual = getOutput(stdin);
    String expected = "vHAAWGVqaXliI31Mo0yySxvhDiP1yhyOk3Ast5hfJxOA7HSJVcP5LRgrx0Mffcc4HCoIO5UIuBvRsUB2EqjHWMRObG5wrGbnTHb33RwbBhKyXe1NxXjjzBXaaRB1Ajd710kYwnWRKrh5T3EBomiIA2t7HcmhsivKq4bEB9HWRIvwSh1x22LNNE86Rb74iccL7gHloVJY68WvfCKHGzOF51MX3LyaN8ng3wadwfmWzzs0lCrRFVAGRsNWjiEKmW3sIXHYebvDcILa9yQqWbUYo71JuMVItQ5icCjjDEurAEMPVtxDQ5R8yv9iXzXd8ykKD8H745CJtVSRUXDTUJO83gVmqqRIjREL2B7CaPoAMN0o5Pyb3h5q4NAHo4jfkkYcyH3q1IKwXfUKc1sRDF4sa9eGAmg0HpqpT1LGKG2YSNsw84xYRKz2tPY1F3cADjtDTux0cz8lTy0kM0sDPwGTiPFTXYorp332uF0fAev1j5enTaA6ARjBMMf57upvvhHl";
    assertThat("incorrect decode", actual, is(equalTo(expected)));
  }

  @Test
  @TestGroup({"secret", "test7"})
  @DisplayName("should decode a long message with all kinds of characters")
  public void algoTest7() {
    String stdin = "128\n]OV'E'U@c!ftDzmf'Se<-#)])Xry[_Yqs2z\"CW\\\\H{=2_bk/%Q/ut7_.9I/ZY,zZAP,kQIiB8%4|A/y=U|204VO BsGO3i6V,2ISbw@O<oZ<B$R.K1Un_7Hmzw?.,?4U\n32\n0\n";
    String actual = getOutput(stdin);
    String expected = "=/6f%f5 C`FT$ZMFf3E{lbh=h8RY;?9QSqZa#7<<([|q?BKnd1nUTv?mx)n:9kZ:!0kK1)I\"wds\\!nY|5\\qos6/_\"S'/rIu6kq)3BW /{O:{\"c2m+p5N?v(MZW~mk~s5";
    assertThat("incorrect decode", actual, is(equalTo(expected)));
  }

  @Test
  @TestGroup({"secret", "test10"})
  @DisplayName("should decode a long message with a small offset")
  public void algoTest10() {
    String stdin = "256\nWsZRSMxbReS~W`]wZ_Y\\y%ji'cu2-gp&d0~oyux'wvt)_+'\"g]aX g,kTzgR\"%&&Ys$#d!^[|+S[t*xZU~\"bW--xn\"ac)3g]ok\"c2)4(^}`~e)%3r\"j%11jkn)7yfe889o&;e{w8x<$eyc{nuviq=wu%n-2h8(/mp{;.qv:6/losI3 Dzz&70z?v3}+c<@=402>}pAz7u&3o1?7CBA~::4\"Gx6s3&vE-)v88sgs7o-lkkgivd~r&cj~*}c_\"rOut\n10\n10\n117 253\n8\n199 223\n8\n170 186\n12\n27 36\n6\n91 198\n3\n88 177\n3\n8 240\n7\n196 198\n6\n188 253\n10\n80 240\n3\n";
    String actual = getOutput(stdin);
    String expected = "MiPHICnXATBmFOLfINHKhsYXuRdzuPYnMxgXhdgufecwNyupVLPGnVzZCiVApsttHbrqSoMJkyBJcxgIAjmNCxxdWjJInxMCUQgIwnymDcFdKnjxXgPjvnHILftWDCuuvMcxCYUuVyaCWAYLSTGOzUSbLjoFuelKNYxkOTwslJAEzdQuLOZkdOsKgRkDrvsjfhtTAqThGWdAbphtsrPkkeSxJgEdWHvfbPqqMAMpIfFEEACPHbViGNbmaGCeVEkj";
    assertThat("incorrect decode", actual, is(equalTo(expected)));
  }

  @Test
  @TestGroup({"secret", "test11"})
  @DisplayName("should decode a long message with a wraparound")
  public void algoTest11() {
    String stdin = "312\nJJF =:4#+uvG@yv?<G%qCv|5w~6w&47EnCFSJVDGSse\\oRs{UHHH[\\VcYL\\hLtrkCzjepx|UkMS{gmYzc$wdqVXQqG[foRyixrfxhHgnuql[lNnmZEGXzDHtUsN{O\\mvdHHGNezcR23&?7D)2;DHG&;&5A9&tB&>;BEwu#<B53%r!uxq{F%B=*Cq;I'uw<?~<HyF5&\"?6I&=3+3H5s\"7JH$Gw8(z(?(W*P#4R6SSU$},x}PNXr\\XFLKNB-JJ-243})*%UV )+(M4-)Rwn] ^a`~]XyaSVE>MQPE.LV0-40\"&'},5uG)4+qDq\n48\n6\n31 137\n49\n220 304\n12\n79 84\n20\n207 208\n13\n236 247\n40\n271 284\n44\n";
    String actual = getOutput(stdin);
    String expected = "yyuOlicRZEFvoIFnkvTArFLdGNeGUcfClADQHTBEQqcZmPqySFFFYZTaWJZfJrpiAxhcnvzSiKQyekWdMmaNoTVOoEYdmPwgvpdvfFelsojYjLlkXCEVxBFrSqLyMZktbFFELcxaPabUnfsXajswvUjUdphUDqUmjqtGERkqdbTBPEHAKuTqlYrAjxVEGknNkwIudUQnexUlbZbjdCQfywSvGgWJKbKzMsFWuYvvxGAOsxKISmWSAGFqePmmPUWVALMHxyCLNKpWPLuneTvUXWuTOpXJyhaptshQoySPWSEIJAOXEvXcZAsA";
    assertThat("incorrect decode", actual, is(equalTo(expected)));
  }

  @Test
  @TestGroup({"secret", "test12"})
  @DisplayName("should decode a long message with special characters")
  public void algoTest12() {
    String stdin = "194\ng_;0lv_)H/IfE)oxQM;hxc@>KIl&bs%~/C3/+uAnn=vt+y<'/20Qmd&Ox&Skcnoc qR}(&fc_P-Ths-@N:sBxy+cT:j!jl[yofnV$hKwX_]i2JXVHr0{iy|Cbu]e[JiH]oL(US|naAtdiwwD!kmEjeOM/Sl;*Fzl}f u~iGvC(KKd27FB91!8f2M< QFSdmTmM\n37\n2\n92 145\n48\n124 188\n5\n";
    String actual = getOutput(stdin);
    String expected = "B:ujGQ:c#i$A cJS,(uCS>zx&$G`=N_Yi}mieP{IIwQOeTvailj,H?`*S`.F>IJ>ZL-Xb`A>:+g/CNgz)tN|STe>/tE[tve$ypx`.rU\"bigs<Tb`R|:&s$'Ml go`OnMbtQ-ZX\"sfFyin||I&ACz@;%#d)Bp_{PBS<UKT?|Lx]!!:gl{wnfVm<g#qU'{.?H/H(";
    assertThat("incorrect decode", actual, is(equalTo(expected)));
  }

  @Test
  @TestGroup({"secret", "test13"})
  @DisplayName("should decode a long message with numbers")
  public void algoTest13() {
    String stdin = "512\ne3UzWry1f4nnH9DIHZF4rOddk3vdYbyOFxe4Pkw[4KYE2w5jmU{rWHB1jO:ywqjo9jCo5iSTC4H2U1iIUIyKdq9wpmlyhbYRVRWppf:33WMNN3ECInJqP4S2deqr[oM713qOpqOu81m8w3otEZlTSWdWTgM4loSGMdjIs5Bss2M9hsZDob9OFzQS:eQ$Z$ebT#qGpH)?vx\"TxraF!@TWc|xV?t*BZ\"#FY@vsVa\"%\\YdN`r101+{LKKL/g.izt1.x;*ls')nUri@e+{kb%.)Ml;mGoOQ;SyS-y:#2<(:F@NKJ-+y}D/k|!-VU;.9;\",PPV^Y<O!UYA@PT1UPX4Y5/K*E+B~2WIAL\"1*+/nLJQr(W1!+NV8E#U&B &-~./Vu.N$!2Q0K#,7SOU!+WMnomMI(FX7o\"X~ ',3,EJH%ANtW 2Tu!AEqS8/J-oSRCbo@4\\%@GGi@?6];:>4?XIZ5YcAFuIuB-~E'6TNpSKtutCo_qCZUq^'?fv&_Ut8{Uwghvw\n1\n8\n251 484\n11\n273 341\n11\n462 502\n14\n275 488\n22\n234 490\n11\n308 442\n16\n446 474\n36\n185 267\n14\n";
    String actual = getOutput(stdin);
    String expected = "d2TyVqx0e3mmG8CHGYE3qNccj2ucXaxNEwd3OjvZ3JXD1v4ilTzqVGA0iN9xvpin8iBn4hRSB3G1T0hHTHxJcp8volkxgaXQUQVooe922VLMM2DBHmIpO3R1cdpqZnL602pNopNt70l7v2nsDYkSRVcVSfL3knRFLciHr4Arr1L8grYCna8NEyPR9VBtKtVSEsb8a9y0girEicR7q1EHTmiG0ez3Krs7J1gdGRruMJJ4FXvuvpa2112tMsOUOkhSudGNacI0MDzNsdTKmkft4b5n7vxbzAzTAaJYcOamgurqTRAEkV3D8DmlREPR9CggmupSf8lpXWgkHlgoKpLFbLgMdATykcnDSLMQ1nls5JySCMpxZgEwHdBHOAPQx8PpFCTsRmENYuqwCMyo120okJhzY2DzABINUNgljGcp7yBTv8Ccg4uZQlO2utu5BrBj3NUUwNMDkIHLBMXIZ5YcAFuIuBQCiKZxr5woDEDrUEb4KFbOw0WgvPTs7zTvfguv";
    assertThat("incorrect decode", actual, is(equalTo(expected)));
  }

  @Test
  @TestGroup({"secret", "test14"})
  @DisplayName("should decode a long message with all kinds of characters")
  public void algoTest14() {
    String stdin = "128\n!7m[F{^Yz{[#~Ne:mavGz7HI(1o@-`&9VnfKm'>{K2Uu4V]kwdlqnb_aR@'*W<O)G\"eXy*t>>|aBjIiO!n+ )Q1<Jk-{[ [*7qFOAoF4v}}-R)Kh*J3~jW?3R\"5O,S{C\n36\n10\n96 128\n14\n109 125\n28\n13 71\n9\n63 103\n27\n112 128\n29\n30 90\n49\n93 98\n29\n108 119\n1\n51 77\n42\n91 99\n33\n";
    String actual = getOutput(stdin);
    String expected = "\\rI7\"W:5VW7^Z!8l@4IyMiz{ZcBr_3':WogLn(?|L3Vv5W^lxemHE968)v]`.r&Db=!s5E0bbA&f/8X>o]ynw@ +9ZMzZa=kjE7aS\"XaDKKZ~9[x|=&q]J2'Fu)C c,S";
    assertThat("incorrect decode", actual, is(equalTo(expected)));
  }
}
