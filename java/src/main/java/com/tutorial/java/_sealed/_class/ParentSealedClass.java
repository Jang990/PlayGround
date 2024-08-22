package com.tutorial.java._sealed._class;


public sealed class ParentSealedClass permits /*WrongClass*/ FinalClass, NonSealedClass, SealedClass {
}
