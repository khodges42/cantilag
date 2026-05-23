# cantilag

> Declarative hotpath generation for C.
> Built in Clojure to emit horrifyingly fast C.

---

## What is this?

`cantilag` is an experimental DSL and code generation system for producing aggressively optimized C from high-level intent specifications.

Instead of hand-writing increasingly cursed SIMD-heavy hotpaths, `cantilag` attempts to describe:

* data layout
* execution intent
* memory constraints
* vectorization opportunities
* specialization rules
* branch assumptions
* cache behavior
* parallel execution patterns

…and emit benchmark-grade C.

Think:

* staged compilation
* domain-specific optimization
* declarative performance engineering

[FAQ](docs/faq.md)

[HUH?](docs/huh.md)

[I am a recruiter looking at this](https://linkedin.com/khodges42)

---

## Philosophy

Most abstractions destroy performance accidentally.

`cantilag` attempts to preserve optimization opportunities across abstraction layers instead of forcing downstream compilers to rediscover them.


---

## Why Clojure?

Because Lisp is still the best language for building languages.

Also because writing a C code generator in a dynamic functional language while trying to outperform hand-written systems code is extremely funny.

---

## Example

### Input

```yaml
kernel:
  name: dot_product

types:
  a: float32*
  b: float32*

assumptions:
  aligned: true
  restrict: true
  vectorize: true
  unroll: 8

operation:
  reduce:
    op: sum
    expr: a[i] * b[i]
```

---

### Generated C

```c
float dot_product(const float* __restrict a,
                  const float* __restrict b,
                  size_t len)
{
    float sum = 0.0f;

    #pragma clang loop vectorize(enable)
    #pragma clang loop unroll_count(8)

    for(size_t i = 0; i < len; i++)
    {
        sum += a[i] * b[i];
    }

    return sum;
}
```

---

## Goals

* Generate readable optimized C
* Explore declarative optimization systems
* Experiment with staged compilation
* Preserve optimization intent
* Benchmark against hand-written implementations
* Learn compiler engineering the dangerous way

---

## Non-Goals

* Memory safety
* Enterprise architecture
* ORM integration
* Kubernetes
* “AI-powered synergy”
* Emotional stability

---

## Planned Features

### Optimization Features

* SIMD-aware lowering
* Branch elimination
* Auto-specialization
* Arena allocation strategies
* Loop transformations
* Profile-guided generation
* Cache-aware layouts
* Multi-versioned codegen
* Platform-specific intrinsic backends

### Backends

* C99
* AVX2
* AVX512
* ARM NEON
* CUDA maybe if things get sufficiently cursed

### Tooling

* Benchmark harnesses
* Generated assembly inspection
* Optimization reports
* “Dyno mode” benchmarking
* Hotpath visualization

---

## Roadmap

### Phase 1 — The Engine Starts

* YAML parsing
* AST construction
* Basic C emission
* Function generation
* Primitive loops
* Benchmark harness

### Phase 2 — Spooling

* SIMD support
* Lowering passes
* Optimization passes
* Constraint propagation
* Loop transforms

### Phase 3 — Overboost

* Specialization engine
* Profile-guided generation
* Multi-target backends
* Aggressive codegen strategies

### Phase 4 — Questionable Decisions

* JIT experimentation
* Auto-tuning
* Search-based optimization
* “Can we beat Rust?” hubris

---

## Inspirations

* C
* Zig
* Jai
* Terra
* Halide
* Lisps
* demoscene optimization culture
* HKS anti-lag systems
* Those guys that have those motors that fling old tires into the air on reels

---

## Current Status

Very early. Still spooling.

---

## License

GPLv3
