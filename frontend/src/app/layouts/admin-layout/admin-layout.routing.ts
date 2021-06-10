import { Routes } from '@angular/router';

import { ColaboradorComponent } from '../../colaborador/colaborador.component';
import { TableListComponent } from '../../table-list/table-list.component';
import { TypographyComponent } from '../../typography/typography.component';
import { NotificationsComponent } from '../../notifications/notifications.component';
import { EmpresaComponent } from 'app/empresa/empresa.component';
import { PrestadorComponent } from 'app/prestador/prestador.component';


export const AdminLayoutRoutes: Routes = [
    
    { path: 'colaborador',   component: ColaboradorComponent },
    { path: 'empresa',   component: EmpresaComponent },
    { path: 'prestadorservico',   component: PrestadorComponent },
    { path: 'registros',     component: TableListComponent },
    { path: 'typography',     component: TypographyComponent },
    { path: 'notifications',  component: NotificationsComponent },
];
