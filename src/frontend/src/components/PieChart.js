import * as React from 'react';
import { PieChart } from '@mui/x-charts/PieChart';

export default function ChartsOverviewDemo({team}) {
  return (
    <div className='piechart'>
    <PieChart
      series={[
        {
          data: [
            { id: 0, value: team.totalWin},
            { id: 1, value: team.totalLoss},
          ],
        },
      ]}
      width={350}
      height={150}
    />
    </div>
  );
}