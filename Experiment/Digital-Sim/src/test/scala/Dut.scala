import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec
import scala.util._

class Dut_Test extends AnyFlatSpec with ChiselScalatestTester{
    behavior of "Dut"
    it should "pass" in {
        test(new Dut)
        .withAnnotations(Seq(VerilatorBackendAnnotation, WriteVcdAnnotation))
        { c =>
            c.io.A.poke(0.U)
            c.io.B.poke(0.U)
            c.clock.step(1)
            c.io.A.poke(1.U)
            c.io.B.poke(1.U)
            c.clock.step(1)
            c.io.A.poke(0.U)
            c.io.B.poke(1.U)
            c.clock.step(1)
            c.io.A.poke(0.U)
            c.io.B.poke(0.U)
            c.clock.step(1)
            c.io.A.poke(0.U)
            c.io.B.poke(0.U)
            c.clock.step(1)
            c.clock.step(1)
        }
    }
}