using System.Collections.Generic;
using Xunit;

namespace TestProject1
{
	public class RecordTests
	{
		[Fact]
		public void ReadCsv_FileExists_ReturnsRecords()
		{
			// Arrange
			string filePath = "../../../keystone-throughput-and-capacity.csv";
			// Act
			List<Record> records = Program.ReadCsv(filePath);
			// Assert
			Assert.NotEmpty(records);
		}

		[Fact]
		public void ReadCsv_FileNotFound_ThrowsFileNotFoundException()
		{
			// Arrange
			string filePath = "non_existent_file.csv";
			// Act & Assert
			Assert.Throws<FileNotFoundException>(() => Program.ReadCsv(filePath));
		}
	}
}