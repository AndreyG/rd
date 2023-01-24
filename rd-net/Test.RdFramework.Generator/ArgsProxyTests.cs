﻿using Microsoft.CodeAnalysis;

namespace Test.RdFramework.Generator;

[Generator]
public class ArgsProxyTestGenerator : ISourceGenerator
{
  public void Execute(GeneratorExecutionContext context)
  {
    for (int i = 1; i < 55; i++)
    {
      var args = string.Join(", ", Enumerable.Range(0, i).Select(i => i % 2 == 0 ? i.ToString() : $"\"{i}\""));
      var parameters = string.Join(", ", Enumerable.Range(0, i).Select(i => i % 2 == 0 ? $"int p{i}" : $"string p{i}"));
      var body = string.Join(" + ", Enumerable.Range(0, i).Select(i => i % 2 == 0 ? $"p{i}" : $"p{i}.Length"));
      string source = $@"// <auto-generated/>
using JetBrains.Diagnostics;
using JetBrains.Rd.Reflection;
using Microsoft.CodeAnalysis;
using NUnit.Framework;
namespace Test.RdFramework.Reflection;

[TestFixture]
public partial class ProxyGeneratorCalls
{{
  public class Test{i:00} : RdReflectionTestBase
  {{
    [Test]
    public void RunTest()
    {{
      var proxy = SFacade.ActivateProxy<IArgsCalls>(TestLifetime, ServerProtocol);
      var client = CFacade.Activator.ActivateBind<ArgsCalls>(TestLifetime, ClientProtocol);
      Assert.AreEqual(client.Test({args}),
      proxy.Test({args}));
    }}

    [RdRpc] public interface IArgsCalls
    {{
      int Test({parameters});
    }}

    [RdExt] public class ArgsCalls : RdExtReflectionBindableBase, IArgsCalls
    {{
      public int Test({parameters})
        => {body};
    }}
  }}
}}
";
      context.AddSource($"{nameof(ArgsProxyTestGenerator)}.{i:D2}.g.cs", source);
    }
  }

  public void Initialize(GeneratorInitializationContext context)
  {
    // No initialization required for this one
  }
}