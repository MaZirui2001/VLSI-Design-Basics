import chisel3._
import chisel3.util._

class Dut extends Module {
    val io = IO(new Bundle{
        val A = Input(UInt(1.W))
        val B = Input(UInt(1.W))
        val X = Output(UInt(1.W))
        val Z = Output(UInt(1.W))
    })
    val X_reg = RegInit(0.U(1.W))
    val Z_reg = RegInit(0.U(1.W))

    X_reg := io.B
    Z_reg := (Z_reg & X_reg) | io.A

    io.X := X_reg
    io.Z := Z_reg
}