import { TestBed } from '@angular/core/testing';

import { AdminFileUploadService } from './admin-file-upload.service';

describe('AdminFileUploadService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AdminFileUploadService = TestBed.get(AdminFileUploadService);
    expect(service).toBeTruthy();
  });
});
