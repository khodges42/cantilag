# huh.md

````md
# huh?

## okay but what *is* this?

`cantilag` is a weird tool that lets you describe fast code at a higher level, and then generates optimized C for you.

Think:

> "what if instead of hand-writing every horrible optimization manually, we described what we wanted and generated the horrible optimization automatically?"

That’s basically the project.

---

## eli5 version

Imagine you’re making a race car.

Normal programming:
- you build the entire engine by hand every time
- every bolt is manual
- lots of copy-pasting
- lots of suffering

`cantilag` tries to let you instead say:

```text
I want:
- this data layout
- this loop
- this memory pattern
- this optimization strategy
- this assumption about the hardware
````

…and then it builds the engine for you.

The generated code is still C.

But ideally:

* faster
* cleaner
* more specialized
* easier to experiment with

---

## why not just trust the compiler?

Compilers are smart.

But compilers only know what they can *see*.

Humans often know:

* data alignment
* cache behavior
* expected sizes
* branch probabilities
* memory ownership
* usage patterns

…but that information gets lost before the compiler sees the code.

`cantilag` tries to preserve that information longer.

---

## so is this like AI?

No.

This is mostly:

* parsing
* transformations
* optimization passes
* code generation

The system is deterministic.

No chatbot is deciding how your loops work, inshallah

---

## why is it written in clojure?

Because Lisp is absurdly good for building compilers and DSLs.

Code is already shaped like trees.
Lisp likes trees.
I am the lorax.
Rich Hickey is my role model

---

## what does the name mean?

Multiple things:

* C anti-lag
* can't I lag
* turbo anti-lag systems in rally cars
* "make the abstraction layer go faster"

The metaphor is:

> keep the turbo spooled between abstraction layers.

---

## what does it generate?

Currently:

* C code

Eventually maybe:

* SIMD-heavy code
* specialized kernels
* benchmark harnesses
* platform-specific optimized paths
* code that frightens coworkers

---

## what is this inspired by?

A mix of:

* compiler engineering
* Lisp
* demoscene optimization
* game engine hotpaths
* HPC 
* rally cars
* sleep deprivation

---

## what is the goal?

The practical goal:

* explore high-performance code generation

The emotional goal:

* beat hand-written code while doing objectively irresponsible abstractions

---

## is this production ready?

absolutely not


```
```
