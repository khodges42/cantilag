## FAQ

---

### Why is this written in Clojure?

Because homoiconicity and macros are still overpowered for building DSLs and compilers.

Also because:

* parsing trees is pleasant
* transformations are concise
* REPL-driven compiler development is fun
* generating C from Lisp makes my autism happy.

but really, I just like it.
---

### Why not just write C?

Because the point is not merely writing C.

The point is preserving optimization intent *before* the compiler loses semantic information.

`cantilag` exists in the space between:

* hand-written systems code
* compiler optimization
* declarative intent specification

---

### Why not just use Rust/Zig/C++?

Those are languages.

`cantilag` is attempting to become:

* a code generation system
* optimization orchestration layer
* specialization engine
* “performance intent compiler”

The output target just happens to currently be C.

---

### Is this a compiler?

Kind of.

Currently it is closer to:

* staged code generation
* transformation pipelines
* optimization-oriented lowering

Over time it may become increasingly compiler-shaped.

This is how these things usually begin.

---

### Is this serious?

Unfortunately yes.

---

### Is this a joke?

Also yes.

---

### Why YAML?

Because:

* structured configuration is useful
* specifications are inspectable
* external tooling integration is easy

The current format is temporary and may evolve into:

* EDN
* Lisp syntax
* custom IR
* something deeply regrettable

---

### Will this generate unreadable code?

Ideally no

---

### Does it support SIMD?

Planned.

The dream is:

```text id="2xxi4o"
intent → optimization passes → vectorized lowering → platform-specific emission
```

without hand-writing 14 AVX variants.

---

### Will it support GPU codegen?

Maybe.

Current priority is:

* CPU hotpaths
* memory layout
* vectorization
* specialization

But CUDA/OpenCL backends would be extremely funny.

---

### Can this actually beat hand-written code?

I mean, it beats my hand written code.

---

### Is this portable?

The generated C should be.

The optimization assumptions probably are not.

---

### What does “cantilag” mean?

Multiple things simultaneously:

* C anti-lag
* can’t lag
* questionable engineering decisions in pursuit of speed

All correct.

---

### What’s the long-term vision?

Somewhere between:

* a compiler research project
* a performance engineering toolkit
* a systems art piece
* a benchmark competition weapon
* a cry for help

We’ll see what survives first:

* the architecture
* the benchmarks
* or the author.
