package io.github.caio.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * The greeting service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.12.0)",
    comments = "Source: hello_world.proto")
public final class GreeterGrpc {

  private GreeterGrpc() {}

  public static final String SERVICE_NAME = "helloworld.Greeter";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getLoginMethod()} instead. 
  public static final io.grpc.MethodDescriptor<io.github.caio.grpc.LoginRequest,
      io.github.caio.grpc.GenResponse> METHOD_LOGIN = getLoginMethodHelper();

  private static volatile io.grpc.MethodDescriptor<io.github.caio.grpc.LoginRequest,
      io.github.caio.grpc.GenResponse> getLoginMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<io.github.caio.grpc.LoginRequest,
      io.github.caio.grpc.GenResponse> getLoginMethod() {
    return getLoginMethodHelper();
  }

  private static io.grpc.MethodDescriptor<io.github.caio.grpc.LoginRequest,
      io.github.caio.grpc.GenResponse> getLoginMethodHelper() {
    io.grpc.MethodDescriptor<io.github.caio.grpc.LoginRequest, io.github.caio.grpc.GenResponse> getLoginMethod;
    if ((getLoginMethod = GreeterGrpc.getLoginMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getLoginMethod = GreeterGrpc.getLoginMethod) == null) {
          GreeterGrpc.getLoginMethod = getLoginMethod = 
              io.grpc.MethodDescriptor.<io.github.caio.grpc.LoginRequest, io.github.caio.grpc.GenResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "helloworld.Greeter", "login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.github.caio.grpc.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.github.caio.grpc.GenResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("login"))
                  .build();
          }
        }
     }
     return getLoginMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCTarefaMethod()} instead. 
  public static final io.grpc.MethodDescriptor<io.github.caio.grpc.CTarefaRequest,
      io.github.caio.grpc.GenResponse> METHOD_C_TAREFA = getCTarefaMethodHelper();

  private static volatile io.grpc.MethodDescriptor<io.github.caio.grpc.CTarefaRequest,
      io.github.caio.grpc.GenResponse> getCTarefaMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<io.github.caio.grpc.CTarefaRequest,
      io.github.caio.grpc.GenResponse> getCTarefaMethod() {
    return getCTarefaMethodHelper();
  }

  private static io.grpc.MethodDescriptor<io.github.caio.grpc.CTarefaRequest,
      io.github.caio.grpc.GenResponse> getCTarefaMethodHelper() {
    io.grpc.MethodDescriptor<io.github.caio.grpc.CTarefaRequest, io.github.caio.grpc.GenResponse> getCTarefaMethod;
    if ((getCTarefaMethod = GreeterGrpc.getCTarefaMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getCTarefaMethod = GreeterGrpc.getCTarefaMethod) == null) {
          GreeterGrpc.getCTarefaMethod = getCTarefaMethod = 
              io.grpc.MethodDescriptor.<io.github.caio.grpc.CTarefaRequest, io.github.caio.grpc.GenResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "helloworld.Greeter", "cTarefa"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.github.caio.grpc.CTarefaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.github.caio.grpc.GenResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("cTarefa"))
                  .build();
          }
        }
     }
     return getCTarefaMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRTarefaMethod()} instead. 
  public static final io.grpc.MethodDescriptor<io.github.caio.grpc.RTarefaRequest,
      io.github.caio.grpc.GenResponse> METHOD_R_TAREFA = getRTarefaMethodHelper();

  private static volatile io.grpc.MethodDescriptor<io.github.caio.grpc.RTarefaRequest,
      io.github.caio.grpc.GenResponse> getRTarefaMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<io.github.caio.grpc.RTarefaRequest,
      io.github.caio.grpc.GenResponse> getRTarefaMethod() {
    return getRTarefaMethodHelper();
  }

  private static io.grpc.MethodDescriptor<io.github.caio.grpc.RTarefaRequest,
      io.github.caio.grpc.GenResponse> getRTarefaMethodHelper() {
    io.grpc.MethodDescriptor<io.github.caio.grpc.RTarefaRequest, io.github.caio.grpc.GenResponse> getRTarefaMethod;
    if ((getRTarefaMethod = GreeterGrpc.getRTarefaMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getRTarefaMethod = GreeterGrpc.getRTarefaMethod) == null) {
          GreeterGrpc.getRTarefaMethod = getRTarefaMethod = 
              io.grpc.MethodDescriptor.<io.github.caio.grpc.RTarefaRequest, io.github.caio.grpc.GenResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "helloworld.Greeter", "rTarefa"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.github.caio.grpc.RTarefaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.github.caio.grpc.GenResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("rTarefa"))
                  .build();
          }
        }
     }
     return getRTarefaMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUTarefaMethod()} instead. 
  public static final io.grpc.MethodDescriptor<io.github.caio.grpc.CTarefaRequest,
      io.github.caio.grpc.GenResponse> METHOD_U_TAREFA = getUTarefaMethodHelper();

  private static volatile io.grpc.MethodDescriptor<io.github.caio.grpc.CTarefaRequest,
      io.github.caio.grpc.GenResponse> getUTarefaMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<io.github.caio.grpc.CTarefaRequest,
      io.github.caio.grpc.GenResponse> getUTarefaMethod() {
    return getUTarefaMethodHelper();
  }

  private static io.grpc.MethodDescriptor<io.github.caio.grpc.CTarefaRequest,
      io.github.caio.grpc.GenResponse> getUTarefaMethodHelper() {
    io.grpc.MethodDescriptor<io.github.caio.grpc.CTarefaRequest, io.github.caio.grpc.GenResponse> getUTarefaMethod;
    if ((getUTarefaMethod = GreeterGrpc.getUTarefaMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getUTarefaMethod = GreeterGrpc.getUTarefaMethod) == null) {
          GreeterGrpc.getUTarefaMethod = getUTarefaMethod = 
              io.grpc.MethodDescriptor.<io.github.caio.grpc.CTarefaRequest, io.github.caio.grpc.GenResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "helloworld.Greeter", "uTarefa"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.github.caio.grpc.CTarefaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.github.caio.grpc.GenResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("uTarefa"))
                  .build();
          }
        }
     }
     return getUTarefaMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDTarefaMethod()} instead. 
  public static final io.grpc.MethodDescriptor<io.github.caio.grpc.CTarefaRequest,
      io.github.caio.grpc.GenResponse> METHOD_D_TAREFA = getDTarefaMethodHelper();

  private static volatile io.grpc.MethodDescriptor<io.github.caio.grpc.CTarefaRequest,
      io.github.caio.grpc.GenResponse> getDTarefaMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<io.github.caio.grpc.CTarefaRequest,
      io.github.caio.grpc.GenResponse> getDTarefaMethod() {
    return getDTarefaMethodHelper();
  }

  private static io.grpc.MethodDescriptor<io.github.caio.grpc.CTarefaRequest,
      io.github.caio.grpc.GenResponse> getDTarefaMethodHelper() {
    io.grpc.MethodDescriptor<io.github.caio.grpc.CTarefaRequest, io.github.caio.grpc.GenResponse> getDTarefaMethod;
    if ((getDTarefaMethod = GreeterGrpc.getDTarefaMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getDTarefaMethod = GreeterGrpc.getDTarefaMethod) == null) {
          GreeterGrpc.getDTarefaMethod = getDTarefaMethod = 
              io.grpc.MethodDescriptor.<io.github.caio.grpc.CTarefaRequest, io.github.caio.grpc.GenResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "helloworld.Greeter", "dTarefa"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.github.caio.grpc.CTarefaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.github.caio.grpc.GenResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("dTarefa"))
                  .build();
          }
        }
     }
     return getDTarefaMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GreeterStub newStub(io.grpc.Channel channel) {
    return new GreeterStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GreeterBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GreeterBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GreeterFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GreeterFutureStub(channel);
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static abstract class GreeterImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void login(io.github.caio.grpc.LoginRequest request,
        io.grpc.stub.StreamObserver<io.github.caio.grpc.GenResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethodHelper(), responseObserver);
    }

    /**
     */
    public void cTarefa(io.github.caio.grpc.CTarefaRequest request,
        io.grpc.stub.StreamObserver<io.github.caio.grpc.GenResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCTarefaMethodHelper(), responseObserver);
    }

    /**
     */
    public void rTarefa(io.github.caio.grpc.RTarefaRequest request,
        io.grpc.stub.StreamObserver<io.github.caio.grpc.GenResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRTarefaMethodHelper(), responseObserver);
    }

    /**
     */
    public void uTarefa(io.github.caio.grpc.CTarefaRequest request,
        io.grpc.stub.StreamObserver<io.github.caio.grpc.GenResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUTarefaMethodHelper(), responseObserver);
    }

    /**
     */
    public void dTarefa(io.github.caio.grpc.CTarefaRequest request,
        io.grpc.stub.StreamObserver<io.github.caio.grpc.GenResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDTarefaMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLoginMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                io.github.caio.grpc.LoginRequest,
                io.github.caio.grpc.GenResponse>(
                  this, METHODID_LOGIN)))
          .addMethod(
            getCTarefaMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                io.github.caio.grpc.CTarefaRequest,
                io.github.caio.grpc.GenResponse>(
                  this, METHODID_C_TAREFA)))
          .addMethod(
            getRTarefaMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                io.github.caio.grpc.RTarefaRequest,
                io.github.caio.grpc.GenResponse>(
                  this, METHODID_R_TAREFA)))
          .addMethod(
            getUTarefaMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                io.github.caio.grpc.CTarefaRequest,
                io.github.caio.grpc.GenResponse>(
                  this, METHODID_U_TAREFA)))
          .addMethod(
            getDTarefaMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                io.github.caio.grpc.CTarefaRequest,
                io.github.caio.grpc.GenResponse>(
                  this, METHODID_D_TAREFA)))
          .build();
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class GreeterStub extends io.grpc.stub.AbstractStub<GreeterStub> {
    private GreeterStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GreeterStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreeterStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GreeterStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void login(io.github.caio.grpc.LoginRequest request,
        io.grpc.stub.StreamObserver<io.github.caio.grpc.GenResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cTarefa(io.github.caio.grpc.CTarefaRequest request,
        io.grpc.stub.StreamObserver<io.github.caio.grpc.GenResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCTarefaMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void rTarefa(io.github.caio.grpc.RTarefaRequest request,
        io.grpc.stub.StreamObserver<io.github.caio.grpc.GenResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRTarefaMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void uTarefa(io.github.caio.grpc.CTarefaRequest request,
        io.grpc.stub.StreamObserver<io.github.caio.grpc.GenResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUTarefaMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void dTarefa(io.github.caio.grpc.CTarefaRequest request,
        io.grpc.stub.StreamObserver<io.github.caio.grpc.GenResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDTarefaMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class GreeterBlockingStub extends io.grpc.stub.AbstractStub<GreeterBlockingStub> {
    private GreeterBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GreeterBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreeterBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GreeterBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public io.github.caio.grpc.GenResponse login(io.github.caio.grpc.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public io.github.caio.grpc.GenResponse cTarefa(io.github.caio.grpc.CTarefaRequest request) {
      return blockingUnaryCall(
          getChannel(), getCTarefaMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public io.github.caio.grpc.GenResponse rTarefa(io.github.caio.grpc.RTarefaRequest request) {
      return blockingUnaryCall(
          getChannel(), getRTarefaMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public io.github.caio.grpc.GenResponse uTarefa(io.github.caio.grpc.CTarefaRequest request) {
      return blockingUnaryCall(
          getChannel(), getUTarefaMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public io.github.caio.grpc.GenResponse dTarefa(io.github.caio.grpc.CTarefaRequest request) {
      return blockingUnaryCall(
          getChannel(), getDTarefaMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class GreeterFutureStub extends io.grpc.stub.AbstractStub<GreeterFutureStub> {
    private GreeterFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GreeterFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreeterFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GreeterFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.github.caio.grpc.GenResponse> login(
        io.github.caio.grpc.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.github.caio.grpc.GenResponse> cTarefa(
        io.github.caio.grpc.CTarefaRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCTarefaMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.github.caio.grpc.GenResponse> rTarefa(
        io.github.caio.grpc.RTarefaRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRTarefaMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.github.caio.grpc.GenResponse> uTarefa(
        io.github.caio.grpc.CTarefaRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUTarefaMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.github.caio.grpc.GenResponse> dTarefa(
        io.github.caio.grpc.CTarefaRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDTarefaMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN = 0;
  private static final int METHODID_C_TAREFA = 1;
  private static final int METHODID_R_TAREFA = 2;
  private static final int METHODID_U_TAREFA = 3;
  private static final int METHODID_D_TAREFA = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GreeterImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GreeterImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN:
          serviceImpl.login((io.github.caio.grpc.LoginRequest) request,
              (io.grpc.stub.StreamObserver<io.github.caio.grpc.GenResponse>) responseObserver);
          break;
        case METHODID_C_TAREFA:
          serviceImpl.cTarefa((io.github.caio.grpc.CTarefaRequest) request,
              (io.grpc.stub.StreamObserver<io.github.caio.grpc.GenResponse>) responseObserver);
          break;
        case METHODID_R_TAREFA:
          serviceImpl.rTarefa((io.github.caio.grpc.RTarefaRequest) request,
              (io.grpc.stub.StreamObserver<io.github.caio.grpc.GenResponse>) responseObserver);
          break;
        case METHODID_U_TAREFA:
          serviceImpl.uTarefa((io.github.caio.grpc.CTarefaRequest) request,
              (io.grpc.stub.StreamObserver<io.github.caio.grpc.GenResponse>) responseObserver);
          break;
        case METHODID_D_TAREFA:
          serviceImpl.dTarefa((io.github.caio.grpc.CTarefaRequest) request,
              (io.grpc.stub.StreamObserver<io.github.caio.grpc.GenResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GreeterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GreeterBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.github.caio.grpc.HelloWorldProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Greeter");
    }
  }

  private static final class GreeterFileDescriptorSupplier
      extends GreeterBaseDescriptorSupplier {
    GreeterFileDescriptorSupplier() {}
  }

  private static final class GreeterMethodDescriptorSupplier
      extends GreeterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GreeterMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GreeterGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GreeterFileDescriptorSupplier())
              .addMethod(getLoginMethodHelper())
              .addMethod(getCTarefaMethodHelper())
              .addMethod(getRTarefaMethodHelper())
              .addMethod(getUTarefaMethodHelper())
              .addMethod(getDTarefaMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
