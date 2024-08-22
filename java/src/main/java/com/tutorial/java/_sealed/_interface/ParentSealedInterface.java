package com.tutorial.java._sealed._interface;

public sealed interface ParentSealedInterface permits MyRecord, NonSealedInterface, SealedInterface {
}
